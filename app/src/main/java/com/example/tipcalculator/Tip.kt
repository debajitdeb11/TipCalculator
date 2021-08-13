package com.example.tipcalculator

import kotlin.math.ceil

class Tip(private val cos: Double, private val ros: Double, private val isRoundOff: Boolean) {

    fun calculateTip(): Double {
        return when (isRoundOff) {
            true -> ceil(cos * ros)
            false -> cos * ros
        }
}

}
