package com.example.nfl.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nfl.R
import com.example.nfl.model.Stat
import com.example.nfl.model.TeamEntry

class TeamAdapter(private val teams: List<TeamEntry>) :
    RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {

    inner class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val teamName: TextView = itemView.findViewById(R.id.teamName)
        private val teamIcon: ImageView = itemView.findViewById(R.id.teamicon)
        private val wins: TextView = itemView.findViewById(R.id.wins)
        private val losses: TextView = itemView.findViewById(R.id.losses)
        private val ties: TextView = itemView.findViewById(R.id.ties)

        fun bind(teamEntry: TeamEntry) {
            teamName.text = teamEntry.team?.displayName ?: "Unknown Team"
            val imageURL = teamEntry.team?.logos?.get(0)?.href
            Glide.with(teamIcon.context).load(imageURL).into(teamIcon)
            wins.text = getStatValue(teamEntry.stats, "wins")
            losses.text = getStatValue(teamEntry.stats, "losses")
            ties.text = getStatValue(teamEntry.stats, "ties")
        }

        private fun getStatValue(stats: List<Stat>?, statName: String): String {
            return stats?.firstOrNull { it.name == statName }?.displayValue ?: "0"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_team_row, parent, false)
        return TeamViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bind(teams[position])
    }

    override fun getItemCount(): Int = teams.size
}