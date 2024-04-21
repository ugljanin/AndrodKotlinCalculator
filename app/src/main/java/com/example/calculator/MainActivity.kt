package com.example.calculator

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var btnAdd : Button
    lateinit var btnSubstract : Button
    lateinit var btnMultiply : Button
    lateinit var btnDivide : Button
    lateinit var numA: EditText
    lateinit var numB: EditText
    lateinit var rezultat: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnAdd = findViewById(R.id.btn_add)
        btnSubstract = findViewById(R.id.btn_substract)
        btnMultiply = findViewById(R.id.btn_multiply)
        btnDivide = findViewById(R.id.btn_divide)
        numA = findViewById(R.id.et_a)
        numB = findViewById(R.id.et_b)
        rezultat = findViewById(R.id.tv_rezultat)

        btnAdd.setOnClickListener(this)
        btnSubstract.setOnClickListener(this)
        btnDivide.setOnClickListener(this)
        btnMultiply.setOnClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
    }

    override fun onClick(v: View?) {
        val a = numA.text.toString().toDouble()
        val b = numB.text.toString().toDouble()
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
        Log.d("Rezultat","result $result")
        rezultat.text = "rezultat = ${result.toString()}"
    }
}
