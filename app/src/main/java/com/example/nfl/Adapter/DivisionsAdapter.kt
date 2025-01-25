package com.example.nfl.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nfl.R
import com.example.nfl.model.Division

class DivisionAdapter(private val divisions: List<Division>) :
    RecyclerView.Adapter<DivisionAdapter.DivisionViewHolder>() {

    inner class DivisionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val divisionName: TextView = itemView.findViewById(R.id.divisionName)
        private val teamsRecyclerView: RecyclerView =
            itemView.findViewById(R.id.teamsRecyclerView)

        fun bind(division: Division) {
            divisionName.text = division.name ?: "Unknown Division"
            teamsRecyclerView.layoutManager = LinearLayoutManager(itemView.context)
            teamsRecyclerView.adapter = TeamAdapter(division.standings?.entries ?: emptyList())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DivisionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_division, parent, false)
        return DivisionViewHolder(view)
    }

    override fun onBindViewHolder(holder: DivisionViewHolder, position: Int) {
        holder.bind(divisions[position])
    }

    override fun getItemCount(): Int = divisions.size
}