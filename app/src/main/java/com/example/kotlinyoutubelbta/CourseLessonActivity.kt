package com.example.kotlinyoutubelbta

import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_course_lesson.*



class CourseLessonActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_lesson)

       // webview_course_lesson.setBackgroundColor(Color.RED)

            //getStringExtra(CourseLessonViewHolder.) pass in the viewHolder
        val courseLink = intent.getStringExtra(CourseDetailActivity.CourseLessonViewHolder.COURSE_LESSON_LINK_KEY)

       // println(courseLink)

        //webview_course_lesson.loadUrl("https://crawford30.github.io/crawford_portfolio/")

        //enable loading javascript
        webview_course_lesson.settings.javaScriptEnabled = true
        webview_course_lesson.settings.loadWithOverviewMode = true
        webview_course_lesson.settings.useWideViewPort = true

       webview_course_lesson.loadUrl(courseLink)

       // webview_course_lesson.loadUrl("https://crawford30.github.io/crawford_portfolio/")

    }

}