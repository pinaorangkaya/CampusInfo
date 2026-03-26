package com.pina.layoutexplorer

import android.content.Intent
import android.os.Bundle
import android.view.ViewStub
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var currentProgress = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val rootView = findViewById<android.view.View>(R.id.main)
        rootView?.let {
            ViewCompat.setOnApplyWindowInsetsListener(it) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }

        // --- 1. Logika Intent ---
        val etInputPesan = findViewById<EditText>(R.id.etPesan)
        val btnKirimData = findViewById<Button>(R.id.btnKirim)

        btnKirimData.setOnClickListener {
            val pesan = etInputPesan.text.toString()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("KUNCI_PESAN", pesan)
            startActivity(intent)
        }

        // --- 2. Logika RecyclerView ---
        val dataList = listOf(
            Item("TextView", "Widget untuk menampilkan teks"),
            Item("EditText", "Widget untuk menerima input teks"),
            Item("Button", "Komponen untuk aksi klik"),
            Item("ImageView", "Menampilkan gambar di aplikasi"),
            Item("CardView", "Kontainer dengan efek bayangan"),
            Item("RecyclerView", "Daftar scroll yang efisien"),
            Item("ConstraintLayout", "Layout fleksibel berbasis batasan"),
            Item("LinearLayout", "Layout sejajar vertikal/horizontal"),
            Item("FrameLayout", "Layout untuk menumpuk view"),
            Item("Intent", "Objek untuk perpindahan Activity")
        )

        val rvItems = findViewById<RecyclerView>(R.id.rvItems)
        rvItems.layoutManager = LinearLayoutManager(this)
        rvItems.adapter = ItemAdapter(dataList)

        val stubDetail = findViewById<ViewStub>(R.id.stubDetail)
        val btnDetail = findViewById<Button>(R.id.btnTampilkanDetail)

        btnDetail.setOnClickListener {
            try {
                val inflatedView = stubDetail.inflate()
                val tvTitle = inflatedView.findViewById<TextView>(R.id.tvDetailTitle)
                tvTitle.text = "Detail Berhasil Dimuat!"
                btnDetail.text = "Detail Terpasang"
                btnDetail.isEnabled = false
            } catch (e: Exception) {
                stubDetail.visibility = android.view.View.VISIBLE
            }
        }

        val customProgressView = findViewById<CircleProgressView>(R.id.customProgress)
        val btnTambahProgress = findViewById<Button>(R.id.btnTambahProgress)

        btnTambahProgress.setOnClickListener {
            currentProgress += 10f
            if (currentProgress > 100f) currentProgress = 0f

            customProgressView.setProgress(currentProgress)
        }
    }
}