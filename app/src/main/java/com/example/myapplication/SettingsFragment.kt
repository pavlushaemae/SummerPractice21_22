package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment(R.layout.fragment_settings) {
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSettingsBinding.bind(view)

        with(binding) {
            btnSettingsToTesting.setOnClickListener {
                val bundle = Bundle()
                bundle.putString(
                    "ARG_TEXT",
                    (tvSettingsFragment.text ?: "Error").toString()
                )
                findNavController().navigate(
                    R.id.action_settingsFragment_to_testForCatFragment,
                    bundle
                )
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}