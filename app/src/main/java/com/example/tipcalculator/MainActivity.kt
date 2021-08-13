package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.widget.SwitchCompat

class MainActivity : AppCompatActivity() {
//    private val costField: EditText = findViewById(R.id.cos)
//    private val selectedTip: RadioGroup = findViewById(R.id.radioGroup)
//    private val roundUp: SwitchCompat = findViewById(R.id.roundOff)
//    private val calculateBtn: Button = findViewById(R.id.calculate)
//    private val tipAmountField: TextView = findViewById(R.id.tip)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addListenerOnButton()

    }

    private fun addListenerOnButton() {
        val costField: EditText = findViewById(R.id.cos)
        val selectedTip: RadioGroup = findViewById(R.id.radioGroup)
        val roundUp: SwitchCompat = findViewById(R.id.roundOff)
        val calculateBtn: Button = findViewById(R.id.calculate)
        val tipAmountField: TextView = findViewById(R.id.tip)


        calculateBtn.setOnClickListener {
            val costValue = costField.text.toString().toDouble()
            val tipRadioSelectedId = selectedTip.checkedRadioButtonId
            val getTip = getTipValue(tipRadioSelectedId);
            val roundOffStatus = roundUp.isChecked

            val tip = Tip(costValue,getTip, roundOffStatus)
            tipAmountField.text = "Tip Amount ${tip.calculateTip()}"


        }
    }

    private fun getTipValue(buttonId: Int): Double {
        Log.d(findViewById<RadioButton>(buttonId).id.toString(), "getTipValue: ")
       return when (findViewById<RadioButton>(buttonId).id) {
            R.id.radio1 -> .2
            R.id.radio2 -> .15
            else -> .1
       }

    }

}