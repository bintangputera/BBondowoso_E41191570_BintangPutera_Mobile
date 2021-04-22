package com.elapp.roomsqlitedemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.elapp.roomsqlitedemo.R
import com.elapp.roomsqlitedemo.databinding.ActivityTambahDataBinding
import com.elapp.roomsqlitedemo.db.MahasiswaDatabase
import com.elapp.roomsqlitedemo.db.dao.MahasiswaDao
import com.elapp.roomsqlitedemo.db.entity.Mahasiswa

class TambahDataActivity : AppCompatActivity() {

    private lateinit var database: MahasiswaDatabase
    private lateinit var dao: MahasiswaDao

    private lateinit var mahasiswa: Mahasiswa

    private var isUpdate = false

    private var tambahDataActivityBinding: ActivityTambahDataBinding? = null
    private val binding get() = tambahDataActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tambahDataActivityBinding = ActivityTambahDataBinding.inflate(layoutInflater)
        setContentView(tambahDataActivityBinding?.root)

        checkIntentExtra()

        initDatabase()

        binding?.btnSimpan?.setOnClickListener {
            val nim = binding?.edtNimMahasiswa?.text.toString()
            val nama = binding?.edtNamaMahasiswa?.text.toString()
            val tanggalLahir = binding?.edtTanggalLahirMahasiswa?.text.toString()
            val jenisKelamin = binding?.edtJenisKelaminMahasiswa?.text.toString()
            val alamat = binding?.edtAlamatMahasiswa?.text.toString()
            if (checkForm(nim, nama, tanggalLahir, jenisKelamin, alamat)) {
                if (isUpdate) {
                    saveData(Mahasiswa(mahasiswa.id ,nim, nama, tanggalLahir, jenisKelamin, alamat))
                } else {
                    saveData(Mahasiswa(0 ,nim, nama, tanggalLahir, jenisKelamin, alamat))
                }
                finish()
            }
        }

    }

    private fun checkIntentExtra() {
        if (intent.getParcelableExtra<Mahasiswa>("edit_mahasiswa") != null ){
            isUpdate = true
            mahasiswa = intent.getParcelableExtra("edit_mahasiswa")!!
            Toast.makeText(this, mahasiswa.id.toString(), Toast.LENGTH_SHORT).show()
            binding?.edtNamaMahasiswa?.setText(mahasiswa.namaMahasiswa)
            binding?.edtNimMahasiswa?.setText(mahasiswa.nim)
            binding?.edtAlamatMahasiswa?.setText(mahasiswa.alamat)
            binding?.edtJenisKelaminMahasiswa?.setText(mahasiswa.jenisKelamin)
            binding?.edtTanggalLahirMahasiswa?.setText(mahasiswa.tanggalLahir)
        }
    }

    private fun initDatabase() {
        database = MahasiswaDatabase.getInstance(this)
        dao = database.getMahasiswaDao()
    }

    private fun saveData(mahasiswa: Mahasiswa) {
        if (dao.getById(mahasiswa.id).isEmpty()) {
            dao.insertDataMahasiswa(mahasiswa)
            Toast.makeText(this, "Data mahasiswa berhasil disimpan", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(this, "Data Mahasiswa berhasil diupdate", Toast.LENGTH_SHORT).show()
            dao.updateDataMahasiswa(mahasiswa)
        }
    }

    private fun checkForm(nim: String, nama: String, tanggalLahir: String, jenisKelamin: String, alamat: String): Boolean{
        if (nim.isEmpty()) {
            binding?.edtNimMahasiswa?.requestFocus()
            binding?.edtNimMahasiswa?.error = "NIM tidak boleh kosong"
            return false
        } else if (nama.isEmpty()) {
            binding?.edtNamaMahasiswa?.requestFocus()
            binding?.edtNamaMahasiswa?.error = "Nama tidak boleh kosong"
            return false
        } else if (nama.isEmpty()) {
            binding?.edtNamaMahasiswa?.requestFocus()
            binding?.edtNamaMahasiswa?.error = "Nama tidak boleh kosong"
            return false
        } else if (tanggalLahir.isEmpty()) {
            binding?.edtTanggalLahirMahasiswa?.requestFocus()
            binding?.edtTanggalLahirMahasiswa?.error = "Tanggal Lahir tidak boleh kosong"
            return false
        } else if (jenisKelamin.isEmpty()) {
            binding?.edtJenisKelaminMahasiswa?.requestFocus()
            binding?.edtJenisKelaminMahasiswa?.error = "Jenis Kelamin tidak boleh kosong"
            return false
        } else if (alamat.isEmpty()) {
            binding?.edtAlamatMahasiswa?.requestFocus()
            binding?.edtAlamatMahasiswa?.error = "Alamat tidak boleh kosong"
            return false
        } else {
            return true
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        tambahDataActivityBinding = null
    }

}