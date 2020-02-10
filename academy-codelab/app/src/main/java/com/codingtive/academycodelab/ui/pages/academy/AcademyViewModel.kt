package com.codingtive.academycodelab.ui.pages.academy

import androidx.lifecycle.ViewModel
import com.codingtive.academycodelab.core.utils.DummyData

class AcademyViewModel : ViewModel() {
    fun getCourses() = DummyData.generateDummyCourses()
}
