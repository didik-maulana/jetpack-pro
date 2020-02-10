package com.codingtive.academycodelab.ui.pages.reader.list


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.codingtive.academycodelab.R
import com.codingtive.academycodelab.core.utils.DummyData
import com.codingtive.academycodelab.ui.pages.reader.CourseReaderCallback
import com.codingtive.academycodelab.ui.adapter.ModuleAdapter
import com.codingtive.academycodelab.ui.pages.reader.CourseReaderViewModel
import kotlinx.android.synthetic.main.fragment_module_list.*

/**
 * A simple [Fragment] subclass.
 */
class ModuleListFragment : Fragment() {

    private val courseReaderViewModel: CourseReaderViewModel by lazy {
        ViewModelProvider(requireActivity(), ViewModelProvider.NewInstanceFactory())[CourseReaderViewModel::class.java]
    }

    private lateinit var courseReaderCallback: CourseReaderCallback

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_module_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            setupRecyclerView()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        courseReaderCallback = context as CourseReaderCallback
    }

    private fun setupRecyclerView() {
        val adapter = ModuleAdapter()
        val moduleList = DummyData.generateDummyModules("a14")

        adapter.setModules(moduleList)
        with (rv_module) {
            val dividerItemDecoration = DividerItemDecoration(rv_module.context, DividerItemDecoration.VERTICAL)
            this.adapter = adapter
            setHasFixedSize(true)
            addItemDecoration(dividerItemDecoration)
        }

        adapter.onItemClicked = { position, moduleId ->
            courseReaderCallback.moveTo(position, moduleId)
            courseReaderViewModel.setSelectedModule(moduleId)
        }
    }

    companion object {
        val TAG = ModuleListFragment::class.java.simpleName

        fun newInstance(): ModuleListFragment = ModuleListFragment()
    }
}
