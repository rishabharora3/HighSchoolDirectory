package com.rishabh.a20220630_rishabharora_nycschools.ui.schoollist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.rishabh.a20220630_rishabharora_nycschools.R
import com.rishabh.a20220630_rishabharora_nycschools.databinding.ItemSchoolBinding
import com.rishabh.a20220630_rishabharora_nycschools.ui.models.SchoolListItemResponse

/**
 * Adapter for the school list.
 */
class SchoolListAdapter(private val schoolClickListener: (schoolItem: SchoolListItemResponse) -> Unit) :
    PagingDataAdapter<SchoolListItemResponse, SchoolListAdapter.ViewHolder>(DiffUtilCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemSchoolBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_school,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class ViewHolder(private val binding: ItemSchoolBinding) : RecyclerView.ViewHolder(binding.root) {

        private val context = binding.root.context

        init {
            binding.root.setOnClickListener {
                val schoolItem = getItem(absoluteAdapterPosition)
                schoolItem?.let { schoolClickListener(it) }
            }
        }

        fun bind(item: SchoolListItemResponse) {
            with(binding) {
                schoolItem = item
            }
        }
    }

    /**
     * DiffUtilCallBack for the school list.
     */
    object DiffUtilCallBack : DiffUtil.ItemCallback<SchoolListItemResponse>() {
        override fun areItemsTheSame(oldItem: SchoolListItemResponse, newItem: SchoolListItemResponse): Boolean {
            return oldItem.dbn == newItem.dbn
        }

        override fun areContentsTheSame(oldItem: SchoolListItemResponse, newItem: SchoolListItemResponse): Boolean {
            return oldItem == newItem
        }
    }
}