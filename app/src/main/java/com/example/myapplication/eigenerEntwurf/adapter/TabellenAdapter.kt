package com.example.myapplication.eigenerEntwurf.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.myapplication.eigenerEntwurf.databinding.ListItemTabelleBinding
import com.example.myapplication.eigenerEntwurf.model.Team
import com.example.myapplication.eigenerEntwurf.remote.TAG

class TabellenAdapter(
    private val dataset: List<Team>

) : RecyclerView.Adapter<TabellenAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: ListItemTabelleBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ListItemTabelleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {


        val item = dataset[position]

        Log.d(TAG,"$item")

        holder.binding.logo.load(item.teamIconUrl)
        holder.binding.name.text = item.teamName

        holder.binding.spiele.text = item.matches.toString()
        holder.binding.gewonnen.text = item.won.toString()
        holder.binding.unentschieden.text = item.draw.toString()
        holder.binding.verloren.text = item.lost.toString()
        holder.binding.tore.text = item.goals.toString()
        holder.binding.differenz.text = item.goalDiff.toString()
        holder.binding.punkte.text = item.points.toString()


    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}