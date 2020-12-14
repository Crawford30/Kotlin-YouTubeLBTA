package com.example.kotlinyoutubelbta

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rCV: RecyclerView = findViewById<RecyclerView>(R.id.recyclerView_main)


        //rCV.setBackgroundColor(Color.BLUE)

        //layout manager
        rCV.layoutManager = LinearLayoutManager(this)

        //adapter
        rCV.adapter = MainAdapter() //MainAdapter() empty constrctor
    }
}