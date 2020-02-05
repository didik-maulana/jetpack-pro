package com.codingtive.jetpack.model

class CuboidModel {
    private var length = 0.0
    private var width = 0.0
    private var height = 0.0

    fun getVolume(): Double = length * width * height

    fun getCircumference(): Double = 4 * (length * width * height)

    fun getSurfaceArea(): Double {
        val widthLength = width * length
        val widthHeight = width * height
        val lengthHeight = length * height
        return 2 * (widthLength + widthHeight + lengthHeight)
    }

    fun save(length: Double, width: Double, height: Double) {
        this.length = length
        this.width = width
        this.height = height
    }
}
