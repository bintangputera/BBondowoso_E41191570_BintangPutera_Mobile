package com.elapp.mysharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.elapp.mysharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding:  ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        readSharedPref()

        binding?.btnLogin?.setOnClickListener {
            val nama = binding?.edtUsername?.text
            val password = binding?.edtPassword?.text
            saveSharedPreferences(nama.toString(), password.toString())
        }

    }

    private fun saveSharedPreferences(username: String, password: String){
        val sharedPreferences = getSharedPreferences("login_pref", Context.MODE_PRIVATE)
        val sharedEdit = sharedPreferences.edit()
        sharedEdit.putString("key_username", username)
        sharedEdit.putString("key_password", password)
        sharedEdit.apply()
    }

    private fun readSharedPref(){
        val sharedPreferences = getSharedPreferences("login_pref", Context.MODE_PRIVATE)
        val name = sharedPreferences.getString("key_username", null)
        sharedPreferences.getString("key_password", null)
        Toast.makeText(applicationContext, "Login sebagai $name", Toast.LENGTH_SHORT).show()
    }

}