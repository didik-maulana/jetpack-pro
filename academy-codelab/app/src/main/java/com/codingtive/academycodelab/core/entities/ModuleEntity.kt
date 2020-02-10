package com.codingtive.academycodelab.core.entities

data class ModuleEntity(
    var moduleId: String,
    var courseId: String,
    var title: String,
    var position: Int,
    var read: Boolean = false
)
