package com.codingtive.academycodelab.ui.pages.reader

import com.codingtive.academycodelab.core.utils.DummyData
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class CourseReaderViewModelTest {
    private lateinit var viewModel: CourseReaderViewModel
    private var dummyCourse = DummyData.generateDummyCourses()[0]
    private var courseId = dummyCourse.courseId
    private var dummyModule = DummyData.generateDummyModules(courseId)[0]
    private var moduleId = dummyModule.moduleId

    @Before
    fun init() {
        viewModel = CourseReaderViewModel()
        viewModel.setSelectedCourse(courseId)
        viewModel.setSelectedModule(moduleId)
    }

    @Test
    fun getSelectedModule() {
        val moduleEntity = viewModel.getSelectedModule()
        assertNotNull(moduleEntity)
        assertEquals(moduleEntity, dummyModule)
    }
}
