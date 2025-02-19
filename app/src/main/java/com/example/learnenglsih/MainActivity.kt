package com.example.learnenglsih

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnColors).setOnClickListener {
            openCategory("colors")
        }

        findViewById<Button>(R.id.btnFamily).setOnClickListener {
            openCategory("family")
        }

        findViewById<Button>(R.id.btnNumbers).setOnClickListener {
            openCategory("numbers")
        }
    }

    private fun openCategory(category: String) {
        val intent = Intent(this, WordListActivity::class.java)
        intent.putExtra("CATEGORY", category)
        startActivity(intent)
    }
}