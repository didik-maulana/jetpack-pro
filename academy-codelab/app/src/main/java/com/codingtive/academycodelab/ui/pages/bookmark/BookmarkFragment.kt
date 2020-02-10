package com.codingtive.academycodelab.ui.pages.bookmark


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.codingtive.academycodelab.R
import com.codingtive.academycodelab.core.utils.DummyData
import com.codingtive.academycodelab.ui.adapter.CourseAdapter
import com.codingtive.academycodelab.ui.pages.detail.DetailCourseActivity
import kotlinx.android.synthetic.main.fragment_bookmark.*

/**
 * A simple [Fragment] subclass.
 */
class BookmarkFragment : Fragment() {
    private val bookmarkViewModel: BookmarkViewModel by lazy {
        ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[BookmarkViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bookmark, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            val academyAdapter = CourseAdapter()
            academyAdapter.setBookmarkCourse(true)
            academyAdapter.setCourseList(bookmarkViewModel.getCourses())

            with(rv_bookmark) {
                setHasFixedSize(true)
                adapter = academyAdapter
            }

            academyAdapter.onCourseClickListener = { courseId ->
                context?.let {
                    startActivity(DetailCourseActivity.newIntent(it, courseId))
                }
            }

            academyAdapter.onCourseShareCallback = { courseTitle ->
                shareCourse(courseTitle)
            }
        }
    }

    private fun shareCourse(title: String) {
        val mimeType = "text/plain"
        ShareCompat.IntentBuilder.from(activity).apply {
            setType(mimeType)
            setChooserTitle(resources.getString(R.string.msg_to_share_application))
            setText(resources.getString(R.string.share_text, title))
            startChooser()
        }
    }
}
