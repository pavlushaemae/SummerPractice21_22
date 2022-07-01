package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentFavouritesBinding


class FavouritesFragment: Fragment(R.layout.fragment_favourites) {
    private  var _binding: FragmentFavouritesBinding? = null
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFavouritesBinding.bind(view)

        with(binding){
            btnFavouritesToTesting.setOnClickListener {
                val bundle = Bundle()
                bundle.putString(
                    "ARG_TEXT",
                    (tvFavouritesFragment.text ?: "Error").toString()
                )
                findNavController().navigate(R.id.action_favouritesFragment_to_testForCatFragment,
                    bundle)
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}