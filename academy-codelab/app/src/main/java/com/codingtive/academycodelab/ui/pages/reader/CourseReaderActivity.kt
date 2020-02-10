package com.codingtive.academycodelab.ui.pages.reader

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.codingtive.academycodelab.R
import com.codingtive.academycodelab.ui.pages.reader.content.ModuleContentFragment
import com.codingtive.academycodelab.ui.pages.reader.list.ModuleListFragment

class CourseReaderActivity : AppCompatActivity(), CourseReaderCallback {
    private val courseReaderViewModel: CourseReaderViewModel by lazy {
        ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[CourseReaderViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_reader)

        val courseId = intent?.extras?.getString(EXTRA_COURSE_ID)
        courseId?.let { id ->
            courseReaderViewModel.setSelectedCourse(id)
            populateFragment()
        }
    }

    override fun moveTo(position: Int, moduleId: String) {
        val fragment = ModuleContentFragment.newInstance()
        supportFragmentManager.beginTransaction()
            .add(R.id.frame_container, fragment, ModuleContentFragment.TAG)
            .addToBackStack(null)
            .commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount <= 1) {
            finish()
        } else {
            super.onBackPressed()
        }
    }

    private fun populateFragment() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        var fragment = supportFragmentManager.findFragmentByTag(ModuleListFragment.TAG)
        if (fragment == null) {
            fragment = ModuleListFragment.newInstance()
            fragmentTransaction.add(R.id.frame_container, fragment, ModuleListFragment.TAG)
            fragmentTransaction.addToBackStack(null)
        }
        fragmentTransaction.commit()
    }

    companion object {
        private const val EXTRA_COURSE_ID = "extra_course_id"

        fun newIntent(context: Context, courseId: String): Intent {
            return Intent(context, CourseReaderActivity::class.java).apply {
                putExtra(EXTRA_COURSE_ID, courseId)
            }
        }
    }
}
