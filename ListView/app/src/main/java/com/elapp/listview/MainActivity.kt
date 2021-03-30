package com.elapp.listview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.elapp.listview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ArrayAdapter<CharSequence>

    private var _activityMainBinding: ActivityMainBinding? = null
    private val binding get() = _activityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding?.btnListView?.setOnClickListener {
            startActivity(Intent(this@MainActivity, ListViewActivity::class.java))
        }

        binding?.btnRecyclerView?.setOnClickListener {
            startActivity(Intent(this@MainActivity, RecyclerViewActivity::class.java))
        }

    }

}