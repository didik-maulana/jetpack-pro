package com.codingtive.academycodelab.ui.pages.bookmark

import androidx.lifecycle.ViewModel
import com.codingtive.academycodelab.core.utils.DummyData

class BookmarkViewModel : ViewModel() {
    fun getCourses() = DummyData.generateDummyCourses()
}
