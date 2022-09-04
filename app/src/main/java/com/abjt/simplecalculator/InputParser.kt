package com.abjt.simplecalculator

import android.util.Log

class InputParser private constructor(private val inputStack: InputStack) : OperatorValidator() {

    private var number: String = ""
    private var stackIndex: Int = -1

    fun parse(input: CharSequence, start: Int, end: Int) {
        input.subSequence(start, end).toString().forEachIndexed { index: Int, char: Char ->
            if (isOperator(char).not()) {
                number = number.plus(char.toString())
                Log.d("Neko -> ", "number = $number")
                return@forEachIndexed
            }
            stackIndex++
            Log.d("Neko -> ", "number index = $stackIndex | operator index = ${stackIndex+1}")
            inputStack.add(stackIndex, number.toDouble())
            inputStack.add(stackIndex + 1, char)
            Log.d("Neko -> ", "input stack = $inputStack | size = ${inputStack.size}")
            resetNumber()
        }
    }

    private fun resetNumber() {
        number = ""
    }

    companion object {
        fun createParser(inputStack: InputStack) = InputParser(inputStack)
    }
}