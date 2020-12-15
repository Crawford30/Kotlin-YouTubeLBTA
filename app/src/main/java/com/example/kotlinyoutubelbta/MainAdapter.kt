package com.example.kotlinyoutubelbta

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.video_row.view.*


//class MainAdapter : RecyclerView.Adapter<CustomViewHolder>(){

//modify Adapter to take in the homefeed

class MainAdapter(val homeFeed: HomeFeed) : RecyclerView.Adapter<CustomViewHolder>(){
    //its like the table view delegate in swift

    val videoTitles = listOf<String>("Video Title one", "video Title Two", "Video Title Three", "JJ", "SS", "CC")


    //number of items
    override fun getItemCount(): Int {
        //same as number of items in table view in swift
//        return videoTitles.size

        return homeFeed.videos.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
     //need to create a view
        //done by creating a new layout

        //we use layout inflater to get the view
        val layoutInflater = LayoutInflater.from(parent?.context)

        val cellForRow = layoutInflater.inflate(R.layout.video_row, parent, false)

       // return  cellForRow, but in a constructor  CustomViewHolder(cellForRow)
        return  CustomViewHolder(cellForRow)

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        //https://stackoverflow.com/questions/33914258/kotlin-android-extensions-how-to-get-a-reference-to-a-view-in-a-layout-that-get
        //https://stackoverflow.com/questions/34169562/unresolved-reference-kotlinx

        //access the items in the cell(custom view)

        //val videoTitlePosition  = videoTitles.get(position)

        val video = homeFeed.videos.get(position)
        holder?.view?.textview_video_title?.text = video.name //the view here comes from the custom view
         //https://www.youtube.com/watch?v=jS0buQyfJfs

        holder?.view.textView_channel_name?.text = video.channel.name


    }


}

//The custom view Holder is like the Cell class in a collection view
class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {

}