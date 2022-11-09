package com.binar.projectgroupmakerbinar.ui.main.adapter;

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.binar.projectgroupmakerbinar.data.room.entity.MemberEntity
import com.binar.projectgroupmakerbinar.databinding.ItemMembersBinding

class ListMembersAdapter(private val itemClick: (MemberEntity) -> Unit) :
    RecyclerView.Adapter<ListMembersAdapter.NoteViewHolder>() {

    private var items: MutableList<MemberEntity> = mutableListOf()

    fun setItems(items: List<MemberEntity>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = ItemMembersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding, itemClick)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val context: Context = holder.itemView.getContext()

        holder.bindView(items[position],context)
    }

    override fun getItemCount(): Int = items.size


    class NoteViewHolder(
        private val binding: ItemMembersBinding,
        val itemClick: (MemberEntity) -> Unit,
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindView(item: MemberEntity,context: Context) {
            binding.tvListTitle.text = item.name

//            with(item) {
//                itemView.setOnClickListener { itemClick(this) }
//            }

//            binding.btAddMember.setOnClickListener {
//                val intent = Intent(itemView.context, AddMember::class.java).also {
//                    it.putExtra("GROUPNAME", item.group)
//                }
//                itemView.context.startActivity(intent)
//            }

            binding.btDeleteMember.setOnClickListener {
                Toast.makeText(
                    itemView.context,
                    "Deleted " + item.name ,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}

