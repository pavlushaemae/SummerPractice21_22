package com.example.myapplication.recycler

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.myapplication.databinding.ItemPlanetBinding

class PlanetHolder(
    private val binding: ItemPlanetBinding,
    private val glide: RequestManager,
    private val onItemClick:(Planet) -> Unit,
): RecyclerView.ViewHolder(binding.root) {
    fun onBind(planet: Planet) {
        with(binding) {
            tvName.text = planet.name
            root.setOnClickListener {
                onItemClick(planet)
            }
            glide.load(planet.url).into(ivCover)
        }
    }
}