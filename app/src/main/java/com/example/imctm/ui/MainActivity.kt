package com.example.imctm.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import com.example.imctm.R
import com.example.imctm.databinding.ActivityMainBinding
import com.example.imctm.databinding.ActivityMainBinding.inflate
import com.example.imctm.extensions.text
import com.example.imctm.model.Imc

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var resultGender = ""

    companion object {
        const val IMC_ID = "imc_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalculateImc.setOnClickListener {
            if(binding.tilName.text == "" || binding.tilHeight.text == "" || binding.tilWeight.text == ""){
                Toast.makeText(applicationContext, R.string.toast_warning_inputs, Toast.LENGTH_LONG).show()
                binding.tilName.error = getString(R.string.error_input) 
                binding.tilWeight.error = getString(R.string.error_input)
                binding.tilHeight.error = getString(R.string.error_input)
            } else {
                val name = binding.tilName.text
                val gender = resultGender
                val weight = binding.tilWeight.text.toDouble()
                val height = binding.tilHeight.text.toDouble()
                val imc = Imc(weight, height, name, gender)
                val intent = Intent(applicationContext, ResultActivity::class.java)
                intent.putExtra(IMC_ID, imc)
                startActivity(intent)
            }
        }
    }

    fun onRadioButtonClicked(view: View) {
        if ( view is RadioButton) {
            val checked = view.isChecked

            when (view.getId()){
                R.id.rb_woman ->
                    if (checked) {
                        resultGender = "Feminino"
                    }
                R.id.rb_man ->
                    if(checked) {
                        resultGender = "Masculino"
                    }
            }
        }
    }
}
