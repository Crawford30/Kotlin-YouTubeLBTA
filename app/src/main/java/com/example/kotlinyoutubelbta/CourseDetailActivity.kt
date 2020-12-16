package com.example.kotlinyoutubelbta

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.UiThread
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.course_lesson_row.view.*
import okhttp3.*
import java.io.IOException

class CourseDetailActivity: AppCompatActivity() {

    //https://www.youtube.com/watch?v=ukh3zOLNhmY&pbjreload=101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        //recyclerView_main.setBackgroundColor(Color.RED)

        //layout manager
        recyclerView_main.layoutManager = LinearLayoutManager(this)

        //adapter
        //recyclerView_main.adapter = CourseDetailAdapter() //after modifying we dont need this

        //we'll change the name bar title
//        val navBarTitle = intent.getStringExtra("namething")

        val navBarTitle = intent.getStringExtra(CustomViewHolder.VIDEO_TITLE_KEY)
        supportActionBar?.title = navBarTitle

//        //GET ID
//        val videoId = intent.getIntExtra(CustomViewHolder.VIDEO_ID_KEY,-1)
//        //course detail url
//        val courseDetailURL = "https://api.letsbuildthatapp.com/youtube/course_detail?id=" + videoId

        //println(courseDetailURL)
        fetchJson()



    }


    private fun fetchJson() {

        //GET ID
        val videoId = intent.getIntExtra(CustomViewHolder.VIDEO_ID_KEY,-1)
        //course detail url
        val courseDetailURL = "https://api.letsbuildthatapp.com/youtube/course_detail?id=" + videoId

        //create client
        val client = OkHttpClient()

        //request
        val request = Request.Builder().url(courseDetailURL).build() //.build is to get the response

        client.newCall(request).enqueue(object:Callback{

            //https://youtu.be/2W41M9fWf6I?t=1179

            override fun onResponse(call: Call, response: Response) {
                val body = response?.body?.string()

                //gson ie parsing json
                val gson = GsonBuilder().create()
                val courseLessons =  gson.fromJson(body, Array<CourseLesson>::class.java)

                //whenever we are done fetching, an must run on UIthread
                runOnUiThread {

                    recyclerView_main.adapter = CourseDetailAdapter(courseLessons) //this is the adapter before modification

                }



            }

            override fun onFailure(call: Call, e: IOException) {
                print("Failed to get response")
            }



        })


    }

//========= ADAPTER===
//    private class CourseDetailAdapter: RecyclerView.Adapter<CourseLessonViewHolder>() { //modify the course adapter to  private class CourseDetailAdapter(val courseLessons: Array<CourseLesson>) since we parse it as  val courseLessons =  gson.fromJson(body, Array<CourseLesson>::class.java)


    //setting up CourseDetailAdapter to use course lesson
private class CourseDetailAdapter(val courseLessons: Array<CourseLesson>): RecyclerView.Adapter<CourseLessonViewHolder>() {

    override fun getItemCount(): Int {
        return  courseLessons.size
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

        //fetch the course lession for the correct row

        val courseLesson = courseLessons.get(position)

        //customView coming from the constructor of CourseLessonViewHolder
        holder?.customView?.textView_course_lesson_title?.text = courseLesson.name

        holder?.customView?.textView_course_duration?.text = courseLesson.duration

        //image view
        val imageView = holder?.customView?.imageView_course_lesson_thumbnail
        Picasso.with(holder?.customView?.context).load(courseLesson.imageUrl).into(imageView)

        //
        holder?.courseLesson =  courseLesson

    }


    }

    //====CUSTOM VIEW HOLDER ======
    //private class CourseLessonViewHolder(val customView: View): RecyclerView.ViewHolder(customView){

    //https://youtu.be/UAyGjQBBsys?t=1068
    //modifying above to this  private class CourseLessonViewHolder(val customView: View, var courseLesson: CourseLesson? and onBind view to get link used in intent

     class CourseLessonViewHolder(val customView: View, var courseLesson: CourseLesson?=null): RecyclerView.ViewHolder(customView){

    companion object {
              val COURSE_LESSON_LINK_KEY = "COUSRSE_LESSON_LINK"

          }
        //custom initializer for this class
        init {
            //set on click listener on the custom view object ie customView
            customView.setOnClickListener {

                //println("Attempt to load webview somehow")
                val intent  = Intent(customView.context, CourseLessonActivity::class.java )

                //pass the link to load a webview
                intent.putExtra(COURSE_LESSON_LINK_KEY, courseLesson?.link)
                customView.context.startActivity(intent)

            }
        }

    }




}