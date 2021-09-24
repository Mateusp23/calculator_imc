package com.example.imctm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.imctm.databinding.ActivityResultBinding
import com.example.imctm.databinding.ActivityResultBinding.*
import com.example.imctm.model.Imc

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate(layoutInflater)
        setContentView(binding.root)

        val imcResult = intent.getParcelableExtra<Imc>(MainActivity.IMC_ID)

        binding.tvNameResult.text = imcResult?.name.toString()
        binding.tvGenderResult.text = imcResult?.gender.toString()
        binding.tvHeightResult.text = imcResult?.height.toString()
        binding.tvWeightResult.text = imcResult?.weight.toString()
        binding.tvResult.text = imcResult?.calculateImc(applicationContext)

        binding.toolbar.setOnClickListener { finish() }
    }
}