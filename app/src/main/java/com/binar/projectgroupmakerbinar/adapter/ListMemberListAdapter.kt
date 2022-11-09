package com.binar.projectgroupmakerbinar.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.binar.projectgroupmakerbinar.databinding.ItemMembersBinding
import com.binar.projectgroupmakerbinar.model.ListMember

class ListMemberListAdapter : RecyclerView.Adapter<ListMemberItemViewHolder>() {
    private val data = mutableListOf<ListMember>()

    fun setItemData(newData: List<ListMember>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListMemberItemViewHolder {
        return ListMemberItemViewHolder(
            ItemMembersBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ListMemberItemViewHolder, position: Int) {
        holder.bindView(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}