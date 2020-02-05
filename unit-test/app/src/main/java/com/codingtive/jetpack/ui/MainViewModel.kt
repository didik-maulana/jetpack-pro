package com.codingtive.jetpack.ui

import com.codingtive.jetpack.model.CuboidModel

class MainViewModel(private val cuboidModel: CuboidModel) {

    fun getCircumference() = cuboidModel.getCircumference()

    fun getSurfaceArea() = cuboidModel.getSurfaceArea()

    fun getVolume() = cuboidModel.getVolume()

    fun save(length: Double, width: Double, height: Double) {
        cuboidModel.save(length, width, height)
    }
}
