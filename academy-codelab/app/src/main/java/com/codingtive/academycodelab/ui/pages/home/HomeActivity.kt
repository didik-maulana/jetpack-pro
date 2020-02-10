package com.codingtive.academycodelab.ui.pages.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codingtive.academycodelab.R
import com.codingtive.academycodelab.ui.adapter.SectionPagerAdapter
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.elevation = 0F
        setupPagerAdapter()
    }

    private fun setupPagerAdapter() {
        val sectionPagerAdapter = SectionPagerAdapter(this, supportFragmentManager)
        view_pager.adapter = sectionPagerAdapter
        tabs.setupWithViewPager(view_pager)
    }
}
