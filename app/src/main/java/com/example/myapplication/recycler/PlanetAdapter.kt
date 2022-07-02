package com.example.myapplication.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.myapplication.databinding.ItemPlanetBinding

class PlanetAdapter(
    private val list: List<Planet>,
    private val glide: RequestManager,
    private val onItemClick:(Planet) -> Unit,
): RecyclerView.Adapter<PlanetHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlanetHolder {
        return PlanetHolder(
            ItemPlanetBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            glide,
            onItemClick
        )
    }

    override fun onBindViewHolder(
        holder: PlanetHolder,
        position: Int
    ) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

}