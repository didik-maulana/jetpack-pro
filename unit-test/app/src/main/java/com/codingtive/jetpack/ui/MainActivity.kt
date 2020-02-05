package com.codingtive.jetpack.ui

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.codingtive.jetpack.R
import com.codingtive.jetpack.model.CuboidModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by lazy {
        MainViewModel(CuboidModel())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionClick()
    }

    private fun setActionClick() {
        btn_save.setOnClickListener {
            validateData()
        }

        btn_calculate_volume.setOnClickListener {
            setCalculateResult(mainViewModel.getVolume())
        }

        btn_calculate_circumference.setOnClickListener {
            setCalculateResult(mainViewModel.getCircumference())
        }

        btn_calculate_surface_area.setOnClickListener {
            setCalculateResult(mainViewModel.getSurfaceArea())
        }
    }

    private fun validateData() {
        val length = edt_length.text.toString().trim()
        val width = edt_width.text.toString().trim()
        val height = edt_height.text.toString().trim()

        when {
            length.isBlank() -> edt_length.showEmptyError()
            width.isBlank() -> edt_width.showEmptyError()
            height.isBlank() -> edt_height.showEmptyError()
            else -> mainViewModel.save(length.toDouble(), width.toDouble(), height.toDouble())
        }

        if (edt_length.error == null && edt_width.error == null && edt_height.error == null) {
            setCalculateView(true)
        }
    }

    private fun setCalculateResult(result: Double) {
        tv_result.text = result.toString()
        setCalculateView(false)
    }

    private fun setCalculateView(isShown: Boolean) {
        btn_save.visibility = if (isShown) {
            View.GONE
        } else {
            View.VISIBLE
        }

        view_calculate.visibility = if (isShown) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    private fun EditText.showEmptyError() {
        error = getString(R.string.msg_error_not_empty)
    }
}
