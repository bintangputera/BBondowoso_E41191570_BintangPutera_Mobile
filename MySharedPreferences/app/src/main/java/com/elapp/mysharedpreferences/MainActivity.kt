package com.elapp.mysharedpreferences

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.elapp.mysharedpreferences.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private var binding:  ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.btnLogin?.setOnClickListener {
            val nama = binding?.edtUsername?.text.toString()
            val password = binding?.edtPassword?.text.toString()
            if (checkForm(nama, password)) {
                readSharedPref(nama, password)
            }
        }

        binding?.txLoginDisini?.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

    }

    private fun readSharedPref(username: String, password: String){
        val sharedPreferences = getSharedPreferences("login_pref", Context.MODE_PRIVATE)
        val name = sharedPreferences.getString("key_username", null)
        val pwd = sharedPreferences.getString("key_password", null)
        if(username != name) {
            Toast.makeText(this, "Username tidak terdaftar", Toast.LENGTH_SHORT).show()
        } else if (password != password) {
            Toast.makeText(this, "Password anda salah", Toast.LENGTH_SHORT).show()
        } else if (username == name && password == pwd) {
            Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
        }
    }

    private fun checkForm(username: String?, pwd: String?): Boolean {
        return when {
            username.isNullOrEmpty() -> {
                binding?.edtUsername?.requestFocus()
                binding?.edtUsername?.error = "Username tidak boleh kosong"
                false
            }
            pwd.isNullOrEmpty() -> {
                binding?.edtPassword?.requestFocus()
                binding?.edtPassword?.error = "Password tidak boleh kosong"
                false
            }
            else -> {
                true
            }
        }
    }

}