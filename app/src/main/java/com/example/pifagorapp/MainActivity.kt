package com.example.pifagorapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.pifagorapp.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    fun onClickResult(view: View) {
        if (!isFieldEmpty()){
            val result = getString(R.string.result_info)+ getResult()
            binding.tvResult.text = result
        }

    }

    private fun isFieldEmpty(): Boolean {
        binding.apply {
            if (edA.text.isNullOrEmpty()) edA.error = "zapolni pole"
            if (edB.text.isNullOrEmpty()) edB.error = "zapolni pole"
            return edA.text.isNullOrEmpty() && edB.text.isNullOrEmpty()

        }
    }

    private fun getResult(): String {
        val a: Double
        val b: Double
        binding.apply {
            a = edA.text.toString().toDouble()
            b = edB.text.toString().toDouble()

        }
        return sqrt((a.pow(2) + (b.pow(2)))).toString()

    }


}