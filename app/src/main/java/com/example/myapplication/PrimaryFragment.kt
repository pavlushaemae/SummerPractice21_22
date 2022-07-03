package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.FragmentPrimaryBinding
import com.example.myapplication.recycler.PlanetAdapter
import com.example.myapplication.recycler.PlanetRepository

class PrimaryFragment : Fragment(R.layout.fragment_primary) {
    private var _binding: FragmentPrimaryBinding? = null
    private val binding get() = _binding!!
    private var adapter: PlanetAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentPrimaryBinding.bind(view)
        initAdapter()
    }

    private fun initAdapter() {
        adapter = PlanetAdapter(
            PlanetRepository.planets,
            Glide.with(this)
        ) {
            val action = PrimaryFragmentDirections.actionPrimaryFragmentToSecondaryFragment(it.id)
            binding.root.findNavController().navigate(action)
        }
        binding.rvPlanet.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}