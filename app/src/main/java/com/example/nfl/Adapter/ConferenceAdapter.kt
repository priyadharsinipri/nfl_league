package com.example.nfl.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nfl.R
import com.example.nfl.model.Conference

class ConferenceAdapter(private val conferences: List<Conference>) :
    RecyclerView.Adapter<ConferenceAdapter.ConferenceViewHolder>() {

    inner class ConferenceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val conferenceName: TextView = itemView.findViewById(R.id.conferenceName)
        private val divisionsRecyclerView: RecyclerView =
            itemView.findViewById(R.id.divisionsRecyclerView)

        fun bind(conference: Conference) {
            conferenceName.text = conference.name ?: "Unknown Conference"
            divisionsRecyclerView.layoutManager = LinearLayoutManager(itemView.context)
            divisionsRecyclerView.adapter = DivisionAdapter(conference.groups ?: emptyList())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConferenceViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_conference, parent, false)
        return ConferenceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ConferenceViewHolder, position: Int) {
        holder.bind(conferences[position])
    }

    override fun getItemCount(): Int = conferences.size
}