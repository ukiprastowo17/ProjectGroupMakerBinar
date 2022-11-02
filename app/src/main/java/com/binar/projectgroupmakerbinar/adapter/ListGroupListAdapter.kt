package com.binar.projectgroupmakerbinar.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.binar.projectgroupmakerbinar.databinding.ItemListBinding
import com.binar.projectgroupmakerbinar.model.ListGroup

class ListGroupListAdapter : RecyclerView.Adapter<ListGroupItemViewHolder>() {

    private val data = mutableListOf<ListGroup>()

    fun setItemData(newData: List<ListGroup>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListGroupItemViewHolder {
        return ListGroupItemViewHolder(
            ItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ListGroupItemViewHolder, position: Int) {
        holder.bindView(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}