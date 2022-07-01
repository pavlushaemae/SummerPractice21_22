package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.myapplication.databinding.FragmentTestForCatBinding

import com.google.android.material.snackbar.Snackbar

class TestForCatFragment: Fragment(R.layout.fragment_test_for_cat){
    private  var _binding: FragmentTestForCatBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val text = arguments?.getString("ARG_TEXT").orEmpty()
        if (text.isNotEmpty()){
            Snackbar.make(view, text, Snackbar.LENGTH_LONG).show()
        }
        _binding = FragmentTestForCatBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
        binding.btnChponk.setOnClickListener {
            try{
                val weightNumber = binding.etWeight.text.toString().toFloat()
                val heightNumber = binding.etHeight.text.toString().toInt()
                val ageNumber = binding.etAge.text.toString().toInt()
                val lengthOfName = binding.etName.text.toString().count()

                if (ageNumber in 1..149 &&
                    lengthOfName in 1..50 &&
                    heightNumber in 1..249 &&
                    weightNumber > 0 &&
                    weightNumber < 250
                ) {
                    val value = (weightNumber + heightNumber + ageNumber + lengthOfName)*1000
                    binding.teResult.text = "Вы любите кошек на: $value%. Поздравляю!"
                    Log.e("MainActivity","Вы любите кошек на: $value%")
                } else {
                    binding.teResult.text = "Данные введены некорректно."
                    Log.e("MainActivity","Данные введены некорректно.")
                }
            }catch (e: Exception){
                binding.teResult.text = "Данные введены некорректно."
                Log.e("MainActivity","Данные введены некорректно.")
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}