package com.codingtive.academycodelab.ui.pages.detail

import com.codingtive.academycodelab.core.utils.DummyData
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class DetailCourseViewModelTest {
    private lateinit var viewModel: DetailCourseViewModel
    private val dummyCourse = DummyData.generateDummyCourses()[0]
    private val courseId = dummyCourse.courseId

    @Before
    fun init() {
        viewModel = DetailCourseViewModel()
        viewModel.setSelectedCourse(courseId)
    }

    @Test
    fun getCourse() {
        viewModel.setSelectedCourse(dummyCourse.courseId)
        val courseEntity = viewModel.getCourse()
        assertNotNull(courseEntity)
        assertEquals(dummyCourse.courseId, courseEntity.courseId)
        assertEquals(dummyCourse.title, courseEntity.title)
        assertEquals(dummyCourse.description, courseEntity.description)
        assertEquals(dummyCourse.deadline, courseEntity.deadline)
        assertEquals(dummyCourse.imagePath, courseEntity.imagePath)
        assertEquals(dummyCourse.bookmarked, courseEntity.bookmarked)
    }

    @Test
    fun getModules() {
        val moduleList = viewModel.getModules()
        assertNotNull(moduleList)
        assertEquals(7, moduleList.size)
    }
}
