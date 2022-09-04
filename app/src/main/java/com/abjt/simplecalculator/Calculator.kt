package com.abjt.simplecalculator

interface Calculator {
    fun calculate(operator: Operator): Double
    fun add(x: Double, y: Double): Double
    fun subtract(x: Double, y: Double): Double
    fun multiply(x: Double, y: Double): Double
    fun divide(x: Double, y: Double): Double
    fun showResult(result: Double): Double
}