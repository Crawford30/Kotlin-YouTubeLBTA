package com.example.kotlinyoutubelbta

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MainAdapter : RecyclerView.Adapter<CustomViewHolder>(){
    //its like the table view delegate in swift


    //number of items
    override fun getItemCount(): Int {
        //same as number of items in table view in swift
        return 3
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
     //need to create a view
        //done by creating a new layout

        //we use layout inflater to get the view
        val layoutInflater = LayoutInflater.from(parent?.context)

        val cellForRow = layoutInflater.inflate(R.layout.video_row, parent, false)

       // return  cellForRow

        return  CustomViewHolder(cellForRow)

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


}

//The custome view Holder is like the Cell class in a collection view
class CustomViewHolder(v: View): RecyclerView.ViewHolder(v) {

}