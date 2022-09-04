package com.abjt.simplecalculator

class InputStack {

    private var _currentIndex: Int = INVALID_INDEX
    private var _previousIndex: Int = INVALID_INDEX
    private var _nextIndex: Int = INVALID_INDEX

    val currentIndex
        get() = _currentIndex

    val previousIndex
        get() = _previousIndex

    val nextIndex
        get() = _nextIndex

    private lateinit var value: Any

    private lateinit var _inputStack: MutableList<Any>

    val input
        get() = _inputStack

    init {
        create()
    }

    private fun create() {
        _inputStack = mutableListOf()
    }

    fun add(index: Int, element: Any) {
        _inputStack.add(element)
//        _previousIndex = index - 1
//        _currentIndex = index
//        _nextIndex = index + 1
    }

    fun get(position: Int) = input[position]

    val size
        get() = input.size

    override fun toString(): String = input.toString()

    companion object {
        private const val INVALID_INDEX = -1

        fun createStack() = InputStack()
    }
}