package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.FragmentSecondaryBinding
import com.example.myapplication.recycler.PlanetRepository.planets

class SecondaryFragment : Fragment() {
    private var _binding: FragmentSecondaryBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_secondary, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentSecondaryBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
        val args by navArgs<SecondaryFragmentArgs>()
        val text = args.myArg
        with(binding) {
            tvName.text = "Name: ${planets[text].name}"
            tvDescription.text = "Description: ${planets[text].description}"
            Glide.with(this@SecondaryFragment).load(planets[text].url).into(ivPicture)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}