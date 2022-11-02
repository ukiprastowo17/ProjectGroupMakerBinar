package com.binar.projectgroupmakerbinar.adapter

import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.binar.projectgroupmakerbinar.databinding.ItemListBinding
import com.binar.projectgroupmakerbinar.model.ListGroup
import com.binar.projectgroupmakerbinar.ui.member.AddMember

class ListGroupItemViewHolder(private val binding: ItemListBinding) :
    RecyclerView.ViewHolder(binding.root) {
        fun bindView(item: ListGroup){
            binding.tvListTitle.text = item.name
            binding.tvListDesc.text = item.description
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