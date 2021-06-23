package com.example.moviedbapp.ui.movie

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviedbapp.databinding.MovieListItemBinding
import com.example.moviedbapp.entity.RetrofitApp.Companion.BASE_URL
import com.example.moviedbapp.entity.RetrofitApp.Companion.IMAGE_BASE_URL
import com.example.moviedbapp.entity.movie.Movie

class MovieAdapter: PagingDataAdapter<Movie, MovieAdapter.MovieViewHolder>(DIFF_CALLBACK) {

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = MovieListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    inner class MovieViewHolder(val binding: MovieListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {

            binding.title.text = movie.originalTitle
            binding.releaseDateaa.text = movie.releaseDate
            binding.ratinga.text = movie.voteAverage.toString()

            Glide.with(binding.thumbnail.context)
                .load(IMAGE_BASE_URL + movie.posterPath)
                .into(binding.thumbnail)
        }
    }

    companion object {
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<Movie> = object :
            DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id == newItem.id && oldItem.id == newItem.id
            }
            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(
                oldItem: Movie,
                newItem: Movie
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

}