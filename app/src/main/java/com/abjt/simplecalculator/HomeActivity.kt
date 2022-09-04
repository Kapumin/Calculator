package com.abjt.simplecalculator

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ImageView
import com.abjt.simplecalculator.Operator.*
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
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

    private var isOperatorSelected: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        setClickListeners()
        setupBackground()
    }

    //initialising the view variables here
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

        backgroundView = findViewById(R.id.view_background)
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
                selectedOperators.add(Pair(selectedOperators.size, ADDITION))
            }
        }

        subtract.setOnClickListener {
            if (isOperatorSelected.not()) {
                setInput(SUBTRACTION.symbol.toString())
                selectedOperators.add(Pair(selectedOperators.size, SUBTRACTION))
            }
        }

        multiply.setOnClickListener {
            if (isOperatorSelected.not()) {
                setInput(MULTIPLICATION.symbol.toString())
                selectedOperators.add(Pair(selectedOperators.size, MULTIPLICATION))
            }
        }

        divide.setOnClickListener {
            if (isOperatorSelected.not()) {
                setInput(DIVISION.symbol.toString())
                selectedOperators.add(Pair(selectedOperators.size, DIVISION))
            }
        }

        percentage.setOnClickListener {
            if (isOperatorSelected.not()) {
                setInput(PERCENTAGE.symbol.toString())
                selectedOperators.add(Pair(selectedOperators.size, PERCENTAGE))
            }
        }

        calculate.setOnClickListener {
            if (selectedOperators.size > 1) {
                selectedOperators.forEach {
                }
            }
        }

        clear.setOnClickListener {
            clearInput()
        }

        inputView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(text: CharSequence?, start: Int, count: Int, after: Int) = Unit

            override fun afterTextChanged(editable: Editable?) {
            }

            override fun onTextChanged(changedText: CharSequence?, start: Int, before: Int, count: Int) {
                if (count != 0) {
                    changedText?.let {
                        parseInput(it, before, count)
                        isOperatorSelected = operatorValidator.isOperator(it[count - 1])
                    }
                }
            }
        })
    }

    private fun parseInput(input: CharSequence, start: Int, end: Int) {
        inputParser.parse(input, start, end)
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

    private fun setupBackground() {
        Glide.with(this)
            .load(R.drawable.kurumi)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .into(backgroundView)
    }
}