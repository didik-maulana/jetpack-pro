package com.codingtive.academycodelab.ui.pages.bookmark

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class BookmarkViewModelTest {

    private lateinit var viewModel: BookmarkViewModel

    @Before
    fun init() {
        viewModel = BookmarkViewModel()
    }

    @Test
    fun getCourses() {
        val bookmarkedCourseList = viewModel.getCourses()
        assertNotNull(bookmarkedCourseList)
        assertEquals(5, bookmarkedCourseList.size)
    }
}
