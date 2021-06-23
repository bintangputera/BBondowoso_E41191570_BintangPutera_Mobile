package com.example.moviedbapp.entity.response

import com.example.moviedbapp.entity.movie.Movie

data class ResponseMovie(
    val page: Int,
    val results: List<Movie>
)
