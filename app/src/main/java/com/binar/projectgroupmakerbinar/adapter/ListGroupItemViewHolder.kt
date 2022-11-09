package com.binar.projectgroupmakerbinar.adapter

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import com.binar.projectgroupmakerbinar.databinding.ItemListBinding
import com.binar.projectgroupmakerbinar.model.ListGroup

class ListGroupItemViewHolder(private val binding: ItemListBinding) :
    RecyclerView.ViewHolder(binding.root) {
        fun bindView(item: ListGroup){
            binding.tvListTitle.text = item.name
            binding.tvListDesc.text = item.note
            itemView.setOnClickListener {
//                Toast.makeText(itemView.context,item.name,Toast.LENGTH_SHORT).show()
//                Intent(itemView.context, AddMember::class.java).also {
////                    it.putExtra("PLAYERNAME", playerOneName)
////                    ContextCompat.startActivity(it)
////                    startActivity(it)
//                }
                val intent = Intent(itemView.context, AddMember::class.java)
                itemView.context.startActivity(intent)

            }
        }
}