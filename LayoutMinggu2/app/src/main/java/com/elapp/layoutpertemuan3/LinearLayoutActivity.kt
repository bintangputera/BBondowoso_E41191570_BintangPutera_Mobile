package com.elapp.layoutpertemuan3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class LinearLayoutActivity : AppCompatActivity() {

    private lateinit var edtPada: EditText
    private lateinit var edtSubject: EditText
    private lateinit var edtMessage: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linear_layout)

        edtPada = findViewById(R.id.edt_to)
        edtSubject = findViewById(R.id.edt_subject)
        edtMessage = findViewById(R.id.edt_message)

    }
}