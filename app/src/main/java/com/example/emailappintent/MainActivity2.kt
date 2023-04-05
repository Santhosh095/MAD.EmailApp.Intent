package com.example.emailappintent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        supportActionBar?.hide()

        val mail:EditText = findViewById(R.id.mail)
        val sub:EditText = findViewById(R.id.sub)
        val msg:EditText = findViewById(R.id.msg)
        val sendbtn:Button = findViewById(R.id.send_btn)
        val resetbtn:TextView = findViewById(R.id.reset)

        sendbtn.setOnClickListener {
            val email = mail.text.toString()
            val subject = sub.text.toString()
            val message = msg.text.toString()

            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
                putExtra(Intent.EXTRA_SUBJECT, subject)
                putExtra(Intent.EXTRA_TEXT, message)
                setPackage("com.google.android.gm")
            }

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "Gmail app not found", Toast.LENGTH_SHORT).show()
            }
        }

        resetbtn.setOnClickListener {
            mail.text = null
            sub.text = null
            msg.text = null
        }
    }
}
