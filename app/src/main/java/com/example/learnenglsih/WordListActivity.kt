package com.example.learnenglsih

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WordListActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var wordAdapter: WordAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word_list)

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Get category from intent
        val category = intent.getStringExtra("CATEGORY") ?: "colors"

        // Get words for the category
        val words = getWordsForCategory(category)

        // Initialize and set the WordAdapter
        wordAdapter = WordAdapter(this, words)
        recyclerView.adapter = wordAdapter
    }

    private fun getWordsForCategory(category: String): List<Word> {
        return when (category) {
            "colors" -> createColorWords()
            "family" -> createFamilyWords()
            "numbers" -> createNumberWords()
            else -> emptyList()
        }
    }

    private fun createColorWords(): List<Word> {
        return listOf(
            Word("Red", R.raw.red),
            Word("Blue", R.raw.blue),
            Word("Green", R.raw.green),
            Word("Yellow", R.raw.yellow),
            Word("Purple", R.raw.purple)
        )
    }

    private fun createFamilyWords(): List<Word> {
        return listOf(
            Word("Father", R.raw.father),
            Word("Mother", R.raw.mother),
            Word("Brother", R.raw.brother),
            Word("Sister", R.raw.sister),
            Word("Grandfather", R.raw.grandfather)
        )
    }

    private fun createNumberWords(): List<Word> {
        return listOf(
            Word("One", R.raw.one),
            Word("Two", R.raw.two),
            Word("Three", R.raw.three),
            Word("Four", R.raw.four),
            Word("Five", R.raw.five)
        )
    }
}