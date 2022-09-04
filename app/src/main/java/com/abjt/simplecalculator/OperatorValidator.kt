package com.abjt.simplecalculator

infix fun CharSequence.isOperator(inputChar: Char): Boolean =
    when (inputChar) {
        Operator.ADDITION.symbol -> true
        Operator.SUBTRACTION.symbol -> true
        Operator.MULTIPLICATION.symbol -> true
        Operator.DIVISION.symbol -> true
        Operator.PERCENTAGE.symbol -> true
        else -> false
    }

infix fun CharSequence.startsWithOperator(inputChar: Char): Boolean = length == 1 && this isOperator inputChar