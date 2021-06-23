package com.example.moviedbapp.utils

import com.example.moviedbapp.entity.RetrofitApp
import com.example.moviedbapp.network.movie.MovieService
import com.example.moviedbapp.ui.movie.MovieRepository
import io.reactivex.disposables.CompositeDisposable

object Injection {

    private val provideMovieService: MovieService = RetrofitApp.getMovieService()

    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    fun provideMovieRepository(): MovieRepository = MovieRepository.getInstance(provideMovieService)

}