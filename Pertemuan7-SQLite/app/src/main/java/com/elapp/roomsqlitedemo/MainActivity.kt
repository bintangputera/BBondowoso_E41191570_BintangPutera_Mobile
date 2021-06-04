package com.elapp.roomsqlitedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.elapp.roomsqlitedemo.adapter.MahasiswaAdapter
import com.elapp.roomsqlitedemo.databinding.ActivityMainBinding
import com.elapp.roomsqlitedemo.db.MahasiswaDatabase
import com.elapp.roomsqlitedemo.db.dao.MahasiswaDao
import com.elapp.roomsqlitedemo.db.entity.Mahasiswa
import com.elapp.roomsqlitedemo.ui.TambahDataActivity
import com.elapp.roomsqlitedemo.util.SelectedClickListener

class MainActivity : AppCompatActivity(), SelectedClickListener {

    private var activityMainBinding: ActivityMainBinding? = null
    private val binding get() = activityMainBinding

    private lateinit var database: MahasiswaDatabase
    private lateinit var dao: MahasiswaDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding?.root)

        getDataMahasiswa()

        binding?.btnTambah?.setOnClickListener {
            startActivity(Intent(this, TambahDataActivity::class.java))
        }
    }
    private fun getDataMahasiswa() {
        database = MahasiswaDatabase.getInstance(applicationContext)
        dao = database.getMahasiswaDao()
        val listItems = arrayListOf<Mahasiswa>()
        listItems.addAll(dao.getDataMahasiswa())
        val adapter = MahasiswaAdapter(this)
        adapter.setList(listItems)

        binding?.rvMahasiswa?.layoutManager = LinearLayoutManager(this)
        binding?.rvMahasiswa?.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        getDataMahasiswa()
    }

    override fun onSelectedItem(mahasiswa: Mahasiswa) {
        val intent = Intent(this, TambahDataActivity::class.java)
        intent.putExtra("edit_mahasiswa", mahasiswa)
        startActivity(intent)
    }

    override fun onDeleteItem(mahasiswa: Mahasiswa) {
            val builder = AlertDialog.Builder(this@MainActivity)
            builder.setMessage("Are you sure you want to Delete?")
                    .setCancelable(false)
                    .setPositiveButton("Yes") { dialog, id ->
                        dao.deleteMahasiswa(mahasiswa)
                        Toast.makeText(this, "Data Mahasiswa berhasil dihapus", Toast.LENGTH_SHORT).show()
                        getDataMahasiswa()
                    }
                    .setNegativeButton("No") { dialog, id ->
                        // Dismiss the dialog
                        dialog.dismiss()
                    }
            val alert = builder.create()
            alert.show()
        }

    }
