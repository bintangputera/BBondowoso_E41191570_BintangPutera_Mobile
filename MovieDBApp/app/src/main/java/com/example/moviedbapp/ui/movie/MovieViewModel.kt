package com.example.moviedbapp.ui.movie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.example.moviedbapp.entity.movie.Movie
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.ExperimentalCoroutinesApi

class MovieViewModel(
    private val movieRepository: MovieRepository,
    private val compositeDisposable: CompositeDisposable
): ViewModel() {

    @ExperimentalCoroutinesApi
    fun getMoviePopular(
        apiKey: String
    ): LiveData<PagingData<Movie>> {
        val resultData = MutableLiveData<PagingData<Movie>>()
        compositeDisposable.add(
            movieRepository.getPopularMovieList(apiKey)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        resultData.postValue(it)
                    }, {
                        Log.e("tag_movie_popular_error", "Error Occured : ${it.message}")
                    }
                )
        )
        return resultData
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}