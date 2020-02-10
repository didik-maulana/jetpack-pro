package com.codingtive.academycodelab.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codingtive.academycodelab.R
import com.codingtive.academycodelab.core.entities.ModuleEntity
import com.codingtive.academycodelab.ui.extensions.inflate
import kotlinx.android.synthetic.main.item_module_list.view.*

class ModuleAdapter : RecyclerView.Adapter<ModuleAdapter.ModuleViewHolder>() {
    var onItemClicked: (position: Int, moduleId: String) -> Unit = { _, _ -> }
    private val moduleList = arrayListOf<ModuleEntity>()

    fun setModules(modules: List<ModuleEntity>?) {
        modules?.apply {
            moduleList.clear()
            moduleList.addAll(this)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModuleViewHolder {
        return ModuleViewHolder(parent.inflate(R.layout.item_module_list))
    }

    override fun getItemCount(): Int = moduleList.size

    override fun onBindViewHolder(holder: ModuleViewHolder, position: Int) {
        return holder.bind(moduleList[position])
    }

    inner class ModuleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(module: ModuleEntity) {
            with(itemView) {
                tv_module_title.text = module.title
                setOnClickListener {
                    onItemClicked(adapterPosition, module.moduleId)
                }
            }
        }
    }
}
