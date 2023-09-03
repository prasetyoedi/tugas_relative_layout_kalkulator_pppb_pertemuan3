package com.example.tugaskalkulator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.core.content.ContextCompat
import java.text.DecimalFormat

class MainActivity : ComponentActivity() {
    private lateinit var number1: TextView
    private lateinit var number2: TextView
    private lateinit var result_calculate: TextView
    private lateinit var operator: TextView

    private var num1 = 0
    private var num2 = 0
    private var currentOperator = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.statusBarColor = ContextCompat.getColor(this, R.color.black)

        number1 = findViewById(R.id.number1)
        number2 = findViewById(R.id.number2)
        result_calculate = findViewById(R.id.result_calculate)
        operator = findViewById(R.id.operator)
    }

    fun onNumClick(view: View) {
        val btn = view as Button
        val num = btn.text.toString()
        if (currentOperator.isEmpty()) {
            num1 = num1 * 10 + num.toInt()
            number1.text = num1.toString()
        } else {
            num2 = num2 *  10 + num.toInt()
            number2.text = num2.toString()
        }
    }

    fun onOperatorClick(view: View) {
        val btn = view as Button
        currentOperator = btn.text.toString()
        operator.text = currentOperator
    }

    fun onCalculateClick(view: View) {
        var result = 0.0
        var num1 = num1.toDouble()
        var num2 = num2.toDouble()
        when (currentOperator) {
            "+" -> result = num1 + num2
            "-" -> result = num1 - num2
            "×" -> result = num1 * num2
            "÷" -> {
                if (num2 != 0.0) {
                    result = num1 / num2
                }
            }
        }
        if (result % 1 == 0.0) {
            val intResult = result.toInt()
            result_calculate.text = intResult.toString()
        } else {
            val decimalFormat = DecimalFormat("#." + "#".repeat(10))
            result_calculate.text = decimalFormat.format(result)
        }
    }

    fun onClearClick(view: View) {
        num1 = 0
        num2 = 0
        currentOperator = ""
        operator.text = ""
        number1.text = ""
        number2.text = ""
        result_calculate.text = ""
    }
}