package com.example.tipcalculator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.widget.SwitchCompat
import androidx.core.content.getSystemService
import java.lang.Exception

class MainActivity : AppCompatActivity() {
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

            val costValue = getCost(costField)
            val tipRadioSelectedId = selectedTip.checkedRadioButtonId
            val getTip = getTipValue(tipRadioSelectedId);
            val roundOffStatus = roundUp.isChecked

            val tip = Tip(costValue,getTip, roundOffStatus)
            tipAmountField.text = "Tip Amount ${tip.calculateTip()}"
        }

        costField.setOnKeyListener { view, i, _ -> handleKeyEvent(view, i) }

    }

    private fun getCost (cost: EditText): Double {
        return try {
            cost.text.toString().toDouble()
        } catch (e: Exception) {
            Toast.makeText(this, "Please Enter COS", Toast.LENGTH_SHORT).show()
            0.0
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

    private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }

}