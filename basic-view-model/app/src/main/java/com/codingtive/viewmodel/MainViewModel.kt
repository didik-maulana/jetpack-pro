package com.codingtive.viewmodel

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var result = 0

    fun calculate(length: String, width: String, height: String) {
        result = length.toInt() * width.toInt() * height.toInt()
    }
}
