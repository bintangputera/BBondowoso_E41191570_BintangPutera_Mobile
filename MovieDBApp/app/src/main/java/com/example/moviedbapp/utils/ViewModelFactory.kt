package com.example.moviedbapp.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviedbapp.ui.movie.MovieRepository
import com.example.moviedbapp.ui.movie.MovieViewModel
import io.reactivex.disposables.CompositeDisposable

class ViewModelFactory(
    private val compositeDisposable: CompositeDisposable,
    private val movieRepository: MovieRepository
) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null
        fun getInstance(): ViewModelFactory =
            (instance ?: synchronized(this) {
                instance ?: ViewModelFactory(
                    Injection.provideCompositeDisposable(),
                    Injection.provideMovieRepository()
                )
            })
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(movieRepository, compositeDisposable) as T
            }
            else -> throw Throwable("Unknown Viewmodel Classes" + modelClass.name)
        }
    }
}