package com.example.moviedbapp.source.movie

import androidx.paging.PagingState
import androidx.paging.rxjava2.RxPagingSource
import com.example.moviedbapp.entity.RetrofitApp
import com.example.moviedbapp.entity.movie.Movie
import com.example.moviedbapp.network.movie.MovieService
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import java.io.IOException

class MovieDataSource(
    private val apiKey: String,
    private val apiService: MovieService
): RxPagingSource<Int, Movie>() {

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, Movie>> {
        val page = params.key ?: RetrofitApp.FIRST_PAGE
        return apiService.getPopularMovie(apiKey)
            .subscribeOn(Schedulers.io())
            .map<LoadResult<Int, Movie>> {
                LoadResult.Page(
                    data = it.results,
                    prevKey = if (page == RetrofitApp.FIRST_PAGE) null else page - 1,
                    nextKey = if (page <= it.results.size) null else page + 1,
                )
            }.onErrorReturn { e ->
                when(e) {
                    is IOException -> LoadResult.Error(e)
                    is HttpException -> LoadResult.Error(e)
                    else -> throw e
                }
            }
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        TODO("Not yet implemented")
    }
}