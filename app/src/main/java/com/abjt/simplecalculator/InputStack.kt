package com.abjt.simplecalculator

import android.util.Log

class InputStack {

    private var _currentIndex: Int = INVALID_INDEX

    val currentIndex
        get() = _currentIndex

    val previousIndex
        get() = currentIndex - 1

    val nextIndex
        get() = currentIndex + 1

    private lateinit var value: Any

    private lateinit var _inputStack: MutableList<Any>

    private val inputStack
        get() = _inputStack

    init {
        create()
    }

    private fun create() {
        _inputStack = mutableListOf()
    }

    fun add(index: Int, element: Any) {
        Log.d("Neko -> ", "stack index = $index")
        _inputStack.add(index, element)
    }

    fun get(position: Int) = inputStack[position]

    val size
        get() = inputStack.size

    fun clear() {
        _inputStack.clear()
    }

    override fun toString(): String = inputStack.toString()

    companion object {
        private const val INVALID_INDEX = -1

        fun createStack() = InputStack()
    }
}