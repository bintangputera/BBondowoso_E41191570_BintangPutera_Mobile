package com.example.moviedbapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviedbapp.databinding.ActivityMainBinding
import com.example.moviedbapp.ui.movie.MovieAdapter
import com.example.moviedbapp.ui.movie.MovieViewModel
import com.example.moviedbapp.utils.ViewModelFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi

class MainActivity : AppCompatActivity() {

    private var _activityMainBinding : ActivityMainBinding? = null
    private val binding get() = _activityMainBinding

    private lateinit var adapter: MovieAdapter

    private val viewModel by lazy {
        val factory = ViewModelFactory.getInstance()
        ViewModelProvider(this, factory).get(MovieViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_activityMainBinding?.root)

        initView()
        loadMovie("0dcfafa66f1756ceea9649fdc755584f")
    }

    private fun initView(){
        adapter = MovieAdapter()
        binding?.rvMovie?.adapter = adapter
        binding?.rvMovie?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    @ExperimentalCoroutinesApi
    private fun loadMovie(apiKey: String) {
        viewModel.getMoviePopular(apiKey).observe(this, Observer {
            adapter.submitData(lifecycle, it)
        })
    }

}