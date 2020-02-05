package com.codingtive.jetpack.ui

import com.codingtive.jetpack.model.CuboidModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mockito.*

class MainViewModelTest {
    private lateinit var mainViewModel: MainViewModel
    private lateinit var cuboidModel: CuboidModel

    private val dummyLength = 2.0
    private val dummyWidth = 3.0
    private val dummyHeight = 4.0
    private val dummyVolume = 24.0
    private val dummySurfaceArea = 52.0
    private val dummyCircumference = 96.0

    @Before
    fun before() {
        cuboidModel = mock(CuboidModel::class.java)
        mainViewModel = MainViewModel(cuboidModel)
    }

    @Test
    fun testCircumference() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel)
        mainViewModel.save(dummyLength, dummyWidth, dummyHeight)
        assertEquals(dummyCircumference, mainViewModel.getCircumference(), 0.0001)
    }

    @Test
    fun testSurfaceArea() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel)
        mainViewModel.save(dummyLength, dummyWidth, dummyHeight)
        assertEquals(dummySurfaceArea, mainViewModel.getSurfaceArea(), 0.0001)
    }

    @Test
    fun testVolume() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel)
        mainViewModel.save(dummyLength, dummyWidth, dummyHeight)
        assertEquals(dummyVolume, mainViewModel.getVolume(), 0.0001)
    }

    @Test
    fun testMockVolume() {
        `when`(mainViewModel.getVolume()).thenReturn(dummyVolume)
        val volume = mainViewModel.getVolume()
        verify(cuboidModel).getVolume()
        assertEquals(dummyVolume, volume, 0.0001)
    }

    @Test
    fun testMockCircumference() {
        `when`(mainViewModel.getVolume()).thenReturn(dummyCircumference)
        val circumference = mainViewModel.getCircumference()
        verify(cuboidModel).getCircumference()
        assertEquals(circumference, circumference, 0.0001)
    }

    @Test
    fun testMockSurfaceArea() {
        `when`(mainViewModel.getSurfaceArea()).thenReturn(dummySurfaceArea)
        val surfaceArea = mainViewModel.getSurfaceArea()
        verify(cuboidModel).getSurfaceArea()
        assertEquals(dummySurfaceArea, surfaceArea, 0.0001)
    }

    @Test
    fun save() {
    }
}
