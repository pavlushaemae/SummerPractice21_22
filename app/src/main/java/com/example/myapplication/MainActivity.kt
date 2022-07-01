package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    private var appeal: TextView? = null
    private var result: TextView? = null
    private var button: Button? = null
    private var weight: EditText? = null
    private var height: EditText? = null
    private var age: EditText? = null
    private var name: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        appeal = findViewById(R.id.tv_please)
        button = findViewById(R.id.btn_chponk)
        weight = findViewById(R.id.et_weight)
        height = findViewById(R.id.et_height)
        age = findViewById(R.id.et_age)
        name = findViewById(R.id.et_name)
        result = findViewById(R.id.te_result)
        button?.setOnClickListener {
            try{
                val weightNumber = weight?.text.toString().toFloat()
                val heightNumber = height?.text.toString().toInt()
                val ageNumber = age?.text.toString().toInt()
                val lengthOfName = name?.text.toString().count()

                if (ageNumber in 1..149 &&
                    lengthOfName in 1..50 &&
                    heightNumber in 1..249 &&
                    weightNumber > 0 &&
                    weightNumber < 250
                ) {
                    val value = (weightNumber + heightNumber + ageNumber + lengthOfName)*1000
                    result?.text = "Вы любите кошек на: $value%. Поздравляю!"
                    Log.e("MainActivity","Вы любите кошек на: $value%")
                } else {
                    result?.text = "Данные введены некорректно."
                    Log.e("MainActivity","Данные введены некорректно.")
                }
            }catch (e: Exception){
                result?.text = "Данные введены некорректно."
                Log.e("MainActivity","Данные введены некорректно.")
            }
        }

    }
}