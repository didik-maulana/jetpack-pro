package com.codingtive.academycodelab.ui.pages.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.codingtive.academycodelab.R
import com.codingtive.academycodelab.core.entities.CourseEntity
import com.codingtive.academycodelab.core.utils.DummyData
import com.codingtive.academycodelab.ui.adapter.ModuleAdapter
import com.codingtive.academycodelab.ui.pages.reader.CourseReaderActivity

import kotlinx.android.synthetic.main.activity_detail_course.*
import kotlinx.android.synthetic.main.partial_content_detail_course.*

class DetailCourseActivity : AppCompatActivity() {
    private val detailCourseViewModel: DetailCourseViewModel by lazy {
        ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailCourseViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_course)
        setupActionBar()
        setupModuleRecyclerView()
    }

    private fun setupActionBar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupModuleRecyclerView() {
        val adapter = ModuleAdapter()

        val courseId = intent?.extras?.getString(EXTRA_COURSE_ID)
        courseId?.let { id ->
            detailCourseViewModel.setSelectedCourse(id)
            adapter.setModules(detailCourseViewModel.getModules())
            populateCourse(detailCourseViewModel.getCourse())
        }

        with (rv_module) {
            val dividerItemDecoration = DividerItemDecoration(rv_module.context, DividerItemDecoration.VERTICAL)
            this.adapter = adapter
            setHasFixedSize(true)
            addItemDecoration(dividerItemDecoration)
        }
    }

    private fun populateCourse(courseEntity: CourseEntity) {
        tv_title.text = courseEntity.title
        tv_description.text = courseEntity.description
        tv_date.text = resources.getString(R.string.deadline_date, courseEntity.deadline)

        Glide.with(this)
            .load(courseEntity.imagePath)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
            .into(img_poster)

        btn_start.setOnClickListener {
            startActivity(CourseReaderActivity.newIntent(this, courseEntity.courseId))
        }
    }

    companion object {
        private const val EXTRA_COURSE_ID = "extra_course_id"

        fun newIntent(context: Context, courseId: String): Intent {
            return Intent(context, DetailCourseActivity::class.java).apply {
                putExtra(EXTRA_COURSE_ID, courseId)
            }
        }
    }
}
