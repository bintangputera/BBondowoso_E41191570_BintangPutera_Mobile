package com.elapp.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.elapp.listview.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var mahasiswaAdapter: MahasiswaAdapter
    private lateinit var mahasiswaArrayList: ArrayList<Mahasiswa>

    private var _recyclerViewActivity: ActivityRecyclerViewBinding? = null
    private val binding get() = _recyclerViewActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _recyclerViewActivity = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view)

        addData()

        mahasiswaAdapter = MahasiswaAdapter()
        mahasiswaAdapter.setList(mahasiswaArrayList)

        binding?.rvMahasiswa?.layoutManager = LinearLayoutManager(this)
        binding?.rvMahasiswa?.adapter = mahasiswaAdapter

    }

    fun addData() {
        mahasiswaArrayList = ArrayList<Mahasiswa>()
        with(mahasiswaArrayList){
            add(Mahasiswa("Bintang", "E41191570", "123456789"))
            add(Mahasiswa("Tegar", "E41190868", "123456789"))
            add(Mahasiswa("Rifjan", "E41190860", "123456789"))
            add(Mahasiswa("Ipang", "E41192090", "123456789"))
            add(Mahasiswa("Derby", "E41192010", "123456789"))
            add(Mahasiswa("Reza", "E41193010", "123456789"))
            add(Mahasiswa("Zami", "E41194509", "123456789"))
        }
    }

}