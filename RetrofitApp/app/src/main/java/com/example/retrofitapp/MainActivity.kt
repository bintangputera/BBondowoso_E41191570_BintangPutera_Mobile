package com.example.retrofitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofitapp.databinding.ActivityMainBinding
import com.example.retrofitapp.service.RetrofitService
import com.example.retrofitapp.service.UserService

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var retrofitService: RetrofitService
    private lateinit var userService: UserService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
    }

}