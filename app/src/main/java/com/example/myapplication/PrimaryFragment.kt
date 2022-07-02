package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.FragmentPrimaryBinding
import com.example.myapplication.recycler.Planet
import com.example.myapplication.recycler.PlanetAdapter
import com.example.myapplication.recycler.PlanetRepository

class PrimaryFragment : Fragment(R.layout.fragment_primary) {

    private var _binding: FragmentPrimaryBinding? = null
    private val binding get() = _binding!!

    private var adapter: PlanetAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentPrimaryBinding.bind(view)
    }

    private fun initAdapter() {
        adapter = PlanetAdapter(
            PlanetRepository.planets,
            Glide.with(this)
        ) {
            binding.root.findNavController().navigate(R.id.action_primaryFragment_to_secondaryFragment)
        }
        binding.rvPlanet.adapter = adapter
    }

//    private fun initPref() {
//        val pref = activity?.getSharedPreferences("TEST", Context.MODE_PRIVATE) ?: return
//        val value = pref.getString("PREF_TEXT", "error").orEmpty()
//        binding.root.showSnackbar(value)
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}