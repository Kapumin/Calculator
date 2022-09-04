package com.abjt.simplecalculator

class InputParser private constructor(private val inputStack: InputStack) {

    private var number: String = ""
    private var stackIndex: Int = -1
        get() {
            field += 1
            return field
        }

    fun parse(input: CharSequence, start: Int, end: Int) {
        input.subSequence(start, end).toString().forEach { char: Char ->
            if ((input isOperator char).not()) {
                number = number.plus(char.toString())
                return@forEach
            }
            inputStack.add(stackIndex, number.toDouble())
            inputStack.add(stackIndex, char)
            resetNumber()
        }
    }

    private fun resetNumber() {
        number = ""
    }

    private fun resetStack() {
        inputStack.clear()
    }

    fun reset() {
        resetNumber()
        resetStack()
    }

    companion object {
        fun createParser(inputStack: InputStack) = InputParser(inputStack)
    }
}