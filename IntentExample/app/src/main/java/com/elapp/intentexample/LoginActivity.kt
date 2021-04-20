package com.elapp.intentexample

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.elapp.intentexample.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var _loginActivityBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _loginActivityBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(_loginActivityBinding.root)

        _loginActivityBinding.btnLogin.setOnClickListener {
            /*val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("username", _loginActivityBinding.edtUsername.text.toString())
            startActivity(intent)*/
            openDialCall("081210841382")
        }

    }

    private fun openGoogleMaps() {
        val gmmIntentUri = Uri.parse("google.streetview:cbll=46.414382,10.013988")

        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")

        startActivity(mapIntent)
    }

    private fun openWhatsapp(number: String, text: String) {
        val waUrl = Uri.parse("https://wa.me//$number?text=$text")

        val waIntent = Intent(Intent.ACTION_VIEW, waUrl)
        waIntent.setPackage("com.whatsapp")

        startActivity(waIntent)

    }

    private fun openDialCall(number: String){
        val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number"))
        startActivity(dialPhoneIntent)
    }

}