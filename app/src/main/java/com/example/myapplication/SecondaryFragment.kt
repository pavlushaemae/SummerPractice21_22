package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.myapplication.databinding.FragmentSecondaryBinding

class SecondaryFragment: Fragment() {
    private var _binding: FragmentSecondaryBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_secondary, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentSecondaryBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
//        val args: SecondaryFragmentArgs by navArgs()
//        val text = args.myArg
//        binding.tvName.text = "$text"
        val args by navArgs<SecondaryFragmentArgs>()
        val text = args.myArgg
        binding.tvName.text = "$text"
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}