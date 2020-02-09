package com.codingtive.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setCalculateListener()
    }

    private fun setCalculateListener() {
        btn_calculate.setOnClickListener {
            validateInput()
        }
    }

    private fun validateInput() {
        val length = edt_length.text.toString()
        val width = edt_width.text.toString()
        val height = edt_height.text.toString()

        when {
            length.isBlank() -> edt_length.showEmptyError()
            width.isBlank() -> edt_width.showEmptyError()
            height.isBlank() -> edt_height.showEmptyError()
            else -> {
                mainViewModel.calculate(length, width, height)
                displayResult()
            }
        }
    }

    private fun EditText.showEmptyError() {
        error = context.getString(R.string.msg_error_empty_input)
    }

    private fun displayResult() {
        tv_result.text = "${mainViewModel.result}"
    }
}
