package com.codingtive.academycodelab.ui.pages.detail

import androidx.lifecycle.ViewModel
import com.codingtive.academycodelab.core.entities.CourseEntity
import com.codingtive.academycodelab.core.utils.DummyData

class DetailCourseViewModel : ViewModel() {
    private var courseId = ""

    fun setSelectedCourse(courseId: String) {
        this.courseId = courseId
    }

    fun getCourse(): CourseEntity {
        lateinit var courseEntity: CourseEntity
        val courseList = DummyData.generateDummyCourses()
        courseList.forEach { course ->
            if (course.courseId == courseId) {
                courseEntity = course
            }
        }
        return courseEntity
    }

    fun getModules() = DummyData.generateDummyModules(courseId)
}
