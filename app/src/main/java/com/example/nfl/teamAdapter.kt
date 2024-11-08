package com.example.nfl

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.example.nfl.model.TeamList

class teamAdapter(context: Context,itemList : List<TeamList>) :BaseAdapter() {

    val itemList = itemList;
    val context = context


    override fun getCount(): Int {
     return itemList.size
    }

    override fun getItem(p0: Int): Any {
        return  itemList.get(p0)
    }

    override fun getItemId(p0: Int): Long {
       return itemList.get(p0).team.id.toLong()
    }

    override fun getView(position: Int, view: View?, p2: ViewGroup?): View {
        val view = View.inflate(context,R.layout.team_card,null)
         val imageView = view.findViewById<ImageView>(R.id.team_card_iv)
        val textView = view.findViewById<TextView>(R.id.team_card_text_view)
        val item = itemList.get(position)
        val imageURL = item.team.logos.get(0).href
        textView.text = item.team.displayName
        Glide.with(imageView.context).load(imageURL).into(imageView)
        return view
    }

}