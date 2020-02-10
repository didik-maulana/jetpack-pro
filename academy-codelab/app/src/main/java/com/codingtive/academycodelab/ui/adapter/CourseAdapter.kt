package com.codingtive.academycodelab.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.codingtive.academycodelab.R
import com.codingtive.academycodelab.core.entities.CourseEntity
import com.codingtive.academycodelab.ui.extensions.inflate
import com.codingtive.academycodelab.ui.extensions.setVisible
import kotlinx.android.synthetic.main.item_academy.view.*

class CourseAdapter : RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {
    var onCourseClickListener: (courseId: String) -> Unit = {}
    var onCourseShareCallback: (courseTitle: String) -> Unit = {}

    private var isBookmarkCourse = false
    private var courseList = arrayListOf<CourseEntity>()

    fun setBookmarkCourse(isBookmarkCourse: Boolean) {
        this.isBookmarkCourse = isBookmarkCourse
    }

    fun setCourseList(courseList: List<CourseEntity>?) {
        courseList?.let {
            this.courseList.clear()
            this.courseList.addAll(courseList)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        return CourseViewHolder(parent.inflate(R.layout.item_academy))
    }

    override fun getItemCount(): Int = courseList.size

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        return holder.bind(courseList[position])
    }

    inner class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val glideLoader = Glide.with(itemView.context)

        fun bind(course: CourseEntity) {
            with(itemView) {
                tv_item_title.text = course.title
                tv_item_description.text = course.description
                tv_item_date.text = resources.getString(R.string.deadline_date, course.deadline)

                setOnClickListener {
                    onCourseClickListener(course.courseId)
                }

                img_btn_share.setVisible(isBookmarkCourse)
                img_btn_share.setOnClickListener {
                    onCourseShareCallback(course.title)
                }

                glideLoader.load(course.imagePath)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(img_poster)
            }
        }
    }
}
