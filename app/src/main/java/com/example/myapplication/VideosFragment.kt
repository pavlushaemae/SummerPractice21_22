package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentVideosBinding


class VideosFragment: Fragment(R.layout.fragment_videos) {
    private  var _binding: FragmentVideosBinding? = null
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentVideosBinding.bind(view)

        with(binding){
            btnVideosToTesting.setOnClickListener {
                val bundle = Bundle()
                bundle.putString(
                    "ARG_TEXT",
                    (tvVideosFragment.text ?: "Error").toString()
                )
                findNavController().navigate(R.id.action_videosFragment_to_testForCatFragment,
                    bundle)
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}