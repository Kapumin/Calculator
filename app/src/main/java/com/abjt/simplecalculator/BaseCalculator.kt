package com.abjt.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import com.abjt.simplecalculator.Operator.*

open class BaseCalculator : AppCompatActivity(), Calculator {

    private val inputStack by lazy { InputStack.createStack() }
    protected val inputParser by lazy { InputParser.createParser(inputStack) }

    override fun calculate(operator: Operator): Double {
        return when (operator) {
            ADDITION -> TODO()
            SUBTRACTION -> TODO()
            MULTIPLICATION -> TODO()
            DIVISION -> TODO()
            PERCENTAGE -> TODO()
            CLEAR -> TODO()
            CALCULATE -> TODO()
        }
    }

    override fun add(x: Double, y: Double): Double {
        TODO("Not yet implemented")
    }

    override fun subtract(x: Double, y: Double): Double {
        TODO("Not yet implemented")
    }

    override fun multiply(x: Double, y: Double): Double {
        TODO("Not yet implemented")
    }

    override fun divide(x: Double, y: Double): Double {
        TODO("Not yet implemented")
    }

    override fun showResult(result: Double): Double {
        TODO("Not yet implemented")
    }

    companion object {
        const val ZERO = "0"
        const val ONE = "1"
        const val TWO = "2"
        const val THREE = "3"
        const val FOUR = "4"
        const val FIVE = "5"
        const val SIX = "6"
        const val SEVEN = "7"
        const val EIGHT = "8"
        const val NINE = "9"

        const val EMPTY_INPUT = ""
        const val UNSPECIFIED_OPERAND = 0.0
    }
}