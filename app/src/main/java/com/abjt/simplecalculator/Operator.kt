package com.abjt.simplecalculator

enum class Operator(val symbol: Char, priorities: Int) {
    ADDITION('+', 2),
    SUBTRACTION('-', 1),
    MULTIPLICATION('x', 3),
    DIVISION('\u00F7', 4),
    PERCENTAGE('%', 4),
    CLEAR('C', 0),
    CALCULATE('=', 0)
}