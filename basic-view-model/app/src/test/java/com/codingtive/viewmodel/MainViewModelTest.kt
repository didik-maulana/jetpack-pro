package com.codingtive.viewmodel

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.rules.ExpectedException
import java.lang.NumberFormatException

class MainViewModelTest {
    private lateinit var mainViewModel: MainViewModel

    @get:Rule
    var thrown: ExpectedException = ExpectedException.none()

    @Before
    fun init() {
        mainViewModel = MainViewModel()
    }

    @Test
    fun calculate() {
        val length = "10"
        val width = "5"
        val height = "2"
        val result = 100
        mainViewModel.calculate(length, width, height)
        assertEquals(result, mainViewModel.result)
    }

    @Test
    @Throws(NumberFormatException::class)
    fun calculateDoubleInput() {
        val width = "1"
        val length = "2.4"
        val height = "3"
        thrown.expect(NumberFormatException::class.java)
        thrown.expectMessage("For input string: \"2.4\"")
        mainViewModel.calculate(length, width, height)
    }

    @Test
    @Throws(NumberFormatException::class)
    fun calculateEmptyInput() {
        val width = "1"
        val length = "2"
        val height = ""
        thrown.expect(NumberFormatException::class.java)
        thrown.expectMessage("For input string: \"\"")
        mainViewModel.calculate(length, width, height)
    }
}
