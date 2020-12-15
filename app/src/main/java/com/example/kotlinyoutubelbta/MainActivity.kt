package com.example.kotlinyoutubelbta

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import okhttp3.*
import java.io.IOException


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // val rCV: RecyclerView = findViewById<RecyclerView>(R.id.recyclerView_main)




        //layout manager
        recyclerView_main.layoutManager = LinearLayoutManager(this)

        //adapter
      //  recyclerView_main.adapter = MainAdapter() //MainAdapter() empty constructor

        fetchJson()
    }



    fun fetchJson(){
//        println("JSON")
        val url = "https://api.letsbuildthatapp.com/youtube/home_feed"

        //request
        val request = Request.Builder().url(url).build()

        //construct a client
        val client = OkHttpClient()



        //make a request
        client.newCall(request).enqueue(object: Callback {

            //when request is done
            override fun onResponse(call: Call, response: Response) {
                val body = response?.body?.string()

               // println(body)

                //We gonna construct HomeFeed object from the body string using gson

                val gson = GsonBuilder().create()

               val homeFeed =  gson.fromJson(body, HomeFeed::class.java)

                //since this runs on the background thread
                //we call runUIthred

                runOnUiThread {
                    recyclerView_main.adapter = MainAdapter(homeFeed)
                }



            }


            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute Request")
            }
        })
    }


}


//"id": 3,
//"name": "Kindle Basic Training",
//"link": "https://www.letsbuildthatapp.com/basic-training",
//"imageUrl": "https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/114bec2f-fbfd-4b13-91de-907fe57c6e37",
//"numberOfViews": 7500,
//"channel": {
//    "name": "Lets Build That App",
//    "profileImageUrl": "https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/dda5bc77-327f-4944-8f51-ba4f3651ffdf",
//    "numberOfSubscribers": 100000
//}


//class model for data
class HomeFeed(val videos: List<Video>)

class Video(val id: Int, val name: String, val link:String, val imageURL:String, val numberOfViews: Int,
val channel: Channel)

class Channel(val name: String, val profileImageUrl:String)