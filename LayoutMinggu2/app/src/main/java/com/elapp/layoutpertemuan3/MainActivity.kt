package com.elapp.layoutpertemuan3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.elapp.layoutpertemuan3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var _activityMainBinding: ActivityMainBinding
    private val binding get() = _activityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_activityMainBinding.root)

        initOnClick()
    }

    private fun initOnClick() {
        binding.btnLinearLayout.setOnClickListener {
            startActivity(Intent(this, LinearLayoutActivity::class.java))
        }
    }
}