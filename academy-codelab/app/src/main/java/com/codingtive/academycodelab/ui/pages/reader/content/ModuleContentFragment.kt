package com.codingtive.academycodelab.ui.pages.reader.content


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.codingtive.academycodelab.R
import com.codingtive.academycodelab.core.entities.ModuleEntity
import com.codingtive.academycodelab.ui.pages.reader.CourseReaderViewModel
import kotlinx.android.synthetic.main.fragment_module_content.*

/**
 * A simple [Fragment] subclass.
 */
class ModuleContentFragment : Fragment() {

    private val courseReaderViewModel: CourseReaderViewModel by lazy {
        ViewModelProvider(requireActivity(), ViewModelProvider.NewInstanceFactory())[CourseReaderViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_module_content, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            populateWebView(courseReaderViewModel.getSelectedModule())
        }
    }

    private fun populateWebView(moduleEntity: ModuleEntity) {
        val content = resources.getString(R.string.dummy_data_content, moduleEntity.title)
        web_view.loadData(content, "text/html", "UTF-8")
    }

    companion object {
        val TAG = ModuleContentFragment::class.java.simpleName

        fun newInstance(): ModuleContentFragment = ModuleContentFragment()
    }
}
