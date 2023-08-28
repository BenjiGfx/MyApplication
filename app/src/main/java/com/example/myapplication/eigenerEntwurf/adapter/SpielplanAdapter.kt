package com.example.myapplication.eigenerEntwurf.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.eigenerEntwurf.databinding.ListItemSpielplanBinding
import com.example.myapplication.eigenerEntwurf.model.spielplandaten.SpTeam

class SpielplanAdapter (
    private val dataset: List<SpTeam>
) : RecyclerView.Adapter<SpielplanAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: ListItemSpielplanBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ListItemSpielplanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val item = dataset[position]

        holder.binding.team1.text = item.teamName
        holder.binding.scoreTeam1.text = item.teamName
        holder.binding.scoreTeam1.text = item.pointsTeam1.toString()
        holder.binding.scoreTeam2.text = item.pointsTeam2.toString()
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}