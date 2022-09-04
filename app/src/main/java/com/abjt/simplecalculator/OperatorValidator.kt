package com.abjt.simplecalculator

open class OperatorValidator {
    fun isOperator(inputChar: Char): Boolean =
        when (inputChar) {
            Operator.ADDITION.symbol -> true
            Operator.SUBTRACTION.symbol -> true
            Operator.MULTIPLICATION.symbol -> true
            Operator.DIVISION.symbol -> true
            Operator.PERCENTAGE.symbol -> true
            else -> false
        }
}