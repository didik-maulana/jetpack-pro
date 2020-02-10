package com.codingtive.academycodelab.ui.pages.reader

import androidx.lifecycle.ViewModel
import com.codingtive.academycodelab.core.entities.ModuleEntity
import com.codingtive.academycodelab.core.utils.DummyData

class CourseReaderViewModel : ViewModel() {
    private var courseId = ""
    private var moduleId = ""

    fun setSelectedCourse(courseId: String) {
        this.courseId = courseId
    }

    fun setSelectedModule(moduleId: String) {
        this.moduleId = moduleId
    }

    fun getSelectedModule(): ModuleEntity {
        lateinit var moduleEntity: ModuleEntity
        val moduleList = DummyData.generateDummyModules(courseId)

        for (position in moduleList.indices) {
            val module = moduleList[position]
            if (module.moduleId == moduleId) {
                moduleEntity = module
                break
            }
        }
        return moduleEntity
    }
}
