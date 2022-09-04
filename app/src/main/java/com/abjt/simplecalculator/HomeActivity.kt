package com.abjt.simplecalculator

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ImageView
import com.abjt.simplecalculator.Operator.*
import com.google.android.material.textview.MaterialTextView

class HomeActivity : BaseCalculator() {

    private lateinit var numZero: MaterialTextView
    private lateinit var numOne: MaterialTextView
    private lateinit var numTwo: MaterialTextView
    private lateinit var numThree: MaterialTextView
    private lateinit var numFour: MaterialTextView
    private lateinit var numFive: MaterialTextView
    private lateinit var numSix: MaterialTextView
    private lateinit var numSeven: MaterialTextView
    private lateinit var numEight: MaterialTextView
    private lateinit var numNine: MaterialTextView

    private lateinit var decimal: MaterialTextView

    private lateinit var inputView: MaterialTextView
    private lateinit var calculate: MaterialTextView
    private lateinit var clear: MaterialTextView

    private lateinit var add: MaterialTextView
    private lateinit var subtract: MaterialTextView
    private lateinit var multiply: MaterialTextView
    private lateinit var divide: MaterialTextView
    private lateinit var percentage: MaterialTextView

    private lateinit var backgroundView: ImageView

    private var isOperatorSelected: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        setClickListeners()
    }

    private fun initViews() {
        numZero = findViewById(R.id.num_0)
        numOne = findViewById(R.id.num_1)
        numTwo = findViewById(R.id.num_2)
        numThree = findViewById(R.id.num_3)
        numFour = findViewById(R.id.num_4)
        numFive = findViewById(R.id.num_5)
        numSix = findViewById(R.id.num_6)
        numSeven = findViewById(R.id.num_7)
        numEight = findViewById(R.id.num_8)
        numNine = findViewById(R.id.num_9)

        decimal = findViewById(R.id.mtv_decimal_dot)

        inputView = findViewById(R.id.mtv_input)
        calculate = findViewById(R.id.mtv_calculate)
        clear = findViewById(R.id.mtv_clear)
        add = findViewById(R.id.mtv_add)
        subtract = findViewById(R.id.mtv_subtract)
        multiply = findViewById(R.id.mtv_multiply)
        divide = findViewById(R.id.mtv_divide)
        percentage = findViewById(R.id.mtv_percentage)
    }

    private fun setClickListeners() {
        numZero.setOnClickListener {
            setInput(ZERO)
        }
        numOne.setOnClickListener {
            setInput(ONE)
        }
        numTwo.setOnClickListener {
            setInput(TWO)
        }
        numThree.setOnClickListener {
            setInput(THREE)
        }
        numFour.setOnClickListener {
            setInput(FOUR)
        }
        numFive.setOnClickListener {
            setInput(FIVE)
        }
        numSix.setOnClickListener {
            setInput(SIX)
        }
        numSeven.setOnClickListener {
            setInput(SEVEN)
        }
        numEight.setOnClickListener {
            setInput(EIGHT)
        }
        numNine.setOnClickListener {
            setInput(NINE)
        }

        add.setOnClickListener {
            if (isOperatorSelected.not()) {
                setInput(ADDITION.symbol.toString())
            }
        }

        subtract.setOnClickListener {
            if (isOperatorSelected.not()) {
                setInput(SUBTRACTION.symbol.toString())
            }
        }

        multiply.setOnClickListener {
            if (isOperatorSelected.not()) {
                setInput(MULTIPLICATION.symbol.toString())
            }
        }

        divide.setOnClickListener {
            if (isOperatorSelected.not()) {
                setInput(DIVISION.symbol.toString())
            }
        }

        percentage.setOnClickListener {
            if (isOperatorSelected.not()) {
                setInput(PERCENTAGE.symbol.toString())
            }
        }

        calculate.setOnClickListener {

        }

        clear.setOnClickListener {
            clearInput()
            inputParser.reset()
        }

        inputView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(text: CharSequence?, start: Int, count: Int, after: Int) = Unit

            override fun afterTextChanged(editable: Editable?) = Unit

            override fun onTextChanged(changedText: CharSequence?, start: Int, before: Int, count: Int) {
                if (count != 0) parseInput(changedText, before, count)
            }
        })
    }

    private fun parseInput(input: CharSequence?, start: Int, count: Int): Unit = run {
        input?.let { charSequence ->
            if ((charSequence startsWithOperator charSequence[count - 1]).not()) {
                isOperatorSelected = charSequence isOperator charSequence[count - 1]
                inputParser.parse(charSequence, start, count)
            }
        }
    }

    private fun clearInput() {
        inputView.text = EMPTY_INPUT
    }

    /**
     * @param input : is any number Input included with the operator
     *  setText() or getText() fun from Textview so we call inputView.setText() = inputView.getText().toString to get the already entered input to combine with  the new input
     */
    private fun setInput(input: String) {
        inputView.apply {
            text = text.toString().plus(input)
        }
    }
}