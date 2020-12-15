package com.example.kotlinyoutubelbta

import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CourseDetailActivity: AppCompatActivity() {

    //https://www.youtube.com/watch?v=ukh3zOLNhmY&pbjreload=101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        //recyclerView_main.setBackgroundColor(Color.RED)

        //layout manager
        recyclerView_main.layoutManager = LinearLayoutManager(this)

        //adapter
        recyclerView_main.adapter = CourseDetailAdapter()



    }

//========= ADAPTER===
    private class CourseDetailAdapter: RecyclerView.Adapter<CourseLessonViewHolder>() {

    override fun getItemCount(): Int {
        return  5
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseLessonViewHolder {
        //tells what the view looks like in a list as cell or row

        val layoutInflater = LayoutInflater.from(parent?.context)

        //resource
       val customView =  layoutInflater.inflate(R.layout.course_lesson_row,parent,false)

//        val blueView = View(parent?.context)
//
//        blueView.setBackgroundColor(Color.BLUE)
//
//        blueView.minimumHeight = 50


       return  CourseLessonViewHolder(customView)
    }

    override fun onBindViewHolder(holder: CourseLessonViewHolder, position: Int) {

    }


    }

    //====CUSTOM VIEW HOLDER ======
    private class CourseLessonViewHolder(val customView: View): RecyclerView.ViewHolder(customView){

    }




}