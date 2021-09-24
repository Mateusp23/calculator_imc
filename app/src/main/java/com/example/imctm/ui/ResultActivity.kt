package com.example.imctm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.imctm.R
import com.example.imctm.databinding.ActivityMainBinding
import com.example.imctm.databinding.ActivityResultBinding
import com.example.imctm.databinding.ActivityResultBinding.*
import com.example.imctm.model.Imc

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate(layoutInflater)
        setContentView(binding.root)

        val imc_result = intent.getParcelableExtra<Imc>(MainActivity.IMC_ID)

        binding.tvNameResult.text = imc_result?.name.toString()
        binding.tvGenderResult.text = imc_result?.gender.toString()
        binding.tvHeightResult.text = imc_result?.height.toString()
        binding.tvWeightResult.text = imc_result?.weight.toString()
        binding.tvResult.text = imc_result?.calculateImc(applicationContext)

        binding.toolbar.setOnClickListener { finish() }
    }
}