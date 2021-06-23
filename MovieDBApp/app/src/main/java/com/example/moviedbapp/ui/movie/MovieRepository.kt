package com.example.moviedbapp.ui.movie

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.rxjava2.flowable
import com.example.moviedbapp.entity.RetrofitApp.Companion.FIRST_PAGE
import com.example.moviedbapp.entity.movie.Movie
import com.example.moviedbapp.network.movie.MovieService
import com.example.moviedbapp.source.movie.MovieDataSource
import io.reactivex.Flowable
import kotlinx.coroutines.ExperimentalCoroutinesApi

class MovieRepository(
    private val apiService: MovieService
) {

    companion object {
        @Volatile
        private var instance: MovieRepository? = null
        fun getInstance(apiService: MovieService): MovieRepository =
            instance ?: synchronized(this) {
                instance ?: MovieRepository(apiService)
            }
    }

    @ExperimentalCoroutinesApi
    fun getPopularMovieList(
        apiKey: String
    ): Flowable<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(
                pageSize =20,
                enablePlaceholders = false
            ),
            initialKey = FIRST_PAGE,
            pagingSourceFactory = { MovieDataSource(apiKey, apiService) }
        ).flowable
    }

}