package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button? = findViewById(R.id.btn_chponk)
        val weight: TextInputEditText? = findViewById(R.id.et_weight)
        val height: TextInputEditText? = findViewById(R.id.et_height)
        val age: TextInputEditText? = findViewById(R.id.et_age)
        val name: TextInputEditText? = findViewById(R.id.et_name)
        val result: TextView? = findViewById(R.id.te_result)
        button?.setOnClickListener {
            try {
                val weightNumber = (weight?.text ?: "ERROR").toString().toFloat()
                val heightNumber = (height?.text ?: "ERROR").toString().toInt()
                val ageNumber = (age?.text ?: "ERROR").toString().toInt()
                val lengthOfName = (name?.text ?: "ERROR").toString().count()

                if (ageNumber in 1..149 &&
                    lengthOfName in 1..50 &&
                    heightNumber in 1..249 &&
                    weightNumber > 0 &&
                    weightNumber < 250
                ) {
                    val value = (weightNumber + heightNumber + ageNumber + lengthOfName) * 1000
                    result?.text = "Вы любите кошек на: $value%. Поздравляю!"
                    Log.e("MainActivity", "Вы любите кошек на: $value%")
                } else {
                    result?.text = getString(R.string.incorrect)
                    Log.e("MainActivity", getString(R.string.incorrect))
                }
            } catch (e: Exception) {
                result?.text = getString(R.string.incorrect)
                Log.e("MainActivity", getString(R.string.incorrect))
            }
        }
    }
}