package com.codingtive.academycodelab.ui.pages.academy

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class AcademyViewModelTest {
    private lateinit var viewModel: AcademyViewModel

    @Before
    fun init() {
        viewModel = AcademyViewModel()
    }

    @Test
    fun getCourses() {
        val courseList = viewModel.getCourses()
        assertNotNull(courseList)
        assertEquals(5, courseList.size)
    }
}
