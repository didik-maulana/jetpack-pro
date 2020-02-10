package com.codingtive.academycodelab.ui.pages.academy


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.codingtive.academycodelab.R
import com.codingtive.academycodelab.core.utils.DummyData
import com.codingtive.academycodelab.ui.adapter.CourseAdapter
import com.codingtive.academycodelab.ui.pages.detail.DetailCourseActivity
import kotlinx.android.synthetic.main.fragment_academy.*

/**
 * A simple [Fragment] subclass.
 */
class AcademyFragment : Fragment() {
    private val academyViewModel: AcademyViewModel by lazy {
        ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[AcademyViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_academy, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            val academyAdapter = CourseAdapter()
            academyAdapter.setCourseList(academyViewModel.getCourses())

            with (rv_academy) {
                setHasFixedSize(true)
                adapter = academyAdapter
            }

            academyAdapter.onCourseClickListener = { courseId ->
                context?.let {
                    startActivity(DetailCourseActivity.newIntent(it, courseId))
                }
            }
        }
    }
}
