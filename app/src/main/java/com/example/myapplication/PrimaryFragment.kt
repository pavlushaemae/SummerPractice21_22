package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
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

//        val text = arguments?.getString(ARG_TEXT).orEmpty()
//        initAdapter()
//        initPref()
    }

    private fun initAdapter() {
        adapter = PlanetAdapter(
            PlanetRepository.planets,{
                tototot
            })
//
//
        binding.rvPlanet.adapter = adapter
//        binding.rvPlanet.layoutManager = GridLayoutManager(requireContext(), 2)

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