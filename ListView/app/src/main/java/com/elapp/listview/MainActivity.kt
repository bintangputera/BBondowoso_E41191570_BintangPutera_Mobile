package com.elapp.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.elapp.listview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    private lateinit var adapter: ArrayAdapter<CharSequence>

    private var _activityMainBinding: ActivityMainBinding? = null
    private val binding get() = _activityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        adapter = ArrayAdapter.createFromResource(this, R.array.country_array, android.R.layout.simple_list_item_1)
        binding?.countryListView?.adapter = adapter
        binding?.countryListView?.setOnItemClickListener(this)
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Toast.makeText(this, adapter.getItem(position), Toast.LENGTH_SHORT).show()
    }
}