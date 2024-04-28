package com.example.calculator

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener(this)
        binding.btnSubstract.setOnClickListener(this)
        binding.btnMultiply.setOnClickListener(this)
        binding.btnDivide.setOnClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
    }

    override fun onClick(v: View?) {
        val a = binding.etA.text.toString().toDouble()
        val b = binding.etB.text.toString().toDouble()
        var result = 0.0
        when(v?.id) {
            R.id.btn_add -> {
                result = a + b
            }
            R.id.btn_substract -> {
                result = a - b
            }
            R.id.btn_multiply -> {
                result = a * b
            }
            R.id.btn_divide -> {
                result = a / b
            }
        }
        Log.d("Result","result $result")
        binding.tvRezultat.text = "Result: ${result.toString()}"
    }
}
