package com.elapp.mysharedpreferences

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.elapp.mysharedpreferences.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private var _activityRegisterBinding: ActivityRegisterBinding? = null
    private val binding get() = _activityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _activityRegisterBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(_activityRegisterBinding?.root)

        binding?.btnRegister?.setOnClickListener {
            val username = binding?.edtUsername?.text?.toString()
            val password = binding?.edtPassword?.text?.toString()

            saveSharedPreferences(username, password)
            Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()
        }
        binding?.txLoginDisini?.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun saveSharedPreferences(username: String?, password: String?){
        val sharedPreferences = getSharedPreferences("login_pref", Context.MODE_PRIVATE)
        val sharedEdit = sharedPreferences.edit()
        sharedEdit.putString("key_username", username)
        sharedEdit.putString("key_password", password)
        sharedEdit.apply()
    }

}