package com.pina.helloandroid

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val TAG = "LifecyclePina"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate dipanggil")

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val mainView = findViewById<android.view.View>(R.id.main)
        ViewCompat.setOnApplyWindowInsetsListener(mainView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnTentang = findViewById<Button>(R.id.btnTentang)
        btnTentang.setOnClickListener {
            Toast.makeText(this, "Android dikembangkan oleh Google sejak 2005!", Toast.LENGTH_LONG).show()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() dipanggil")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() dipanggil")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() dipanggil")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() dipanggil")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() dipanggil")
    }
}