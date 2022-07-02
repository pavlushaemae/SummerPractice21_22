package com.example.myapplication.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.myapplication.databinding.ItemPlanetBinding

class PlanetAdapter(
    private var list: List<Planet>,
    private val glide: RequestManager,
    private val onItemClick: (Planet) -> Unit,
) : RecyclerView.Adapter<PlanetHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlanetHolder =
        PlanetHolder(
            binding = ItemPlanetBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            glide = glide,
            onItemClick = onItemClick
        )

    override fun onBindViewHolder(
        holder: PlanetHolder,
        position: Int
    ) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

}