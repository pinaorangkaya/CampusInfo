package com.pina.layoutexplorer

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val tvHasil = findViewById<TextView>(R.id.tvHasil)
        val btnKembali = findViewById<Button>(R.id.btnKembali)

        val pesanDiterima = intent.getStringExtra("KUNCI_PESAN")

        tvHasil.text = pesanDiterima

        btnKembali.setOnClickListener {
            finish()
        }
    }
}