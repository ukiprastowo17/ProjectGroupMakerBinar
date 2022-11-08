package com.catnip.notepadku.ui.main.adapter;

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.binar.projectgroupmakerbinar.model.ListGroup

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class NotesAdapter(private val itemClick: (ListGroup) -> Unit) :
    RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {


    private var items: MutableList<ListGroup> = mutableListOf()

    fun setItems(items: List<ListGroup>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding, itemClick)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bindView(items[position])
    }

    override fun getItemCount(): Int = items.size


    class NoteViewHolder(private val binding: ItemNoteBinding, val itemClick: (NoteWithCategory) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindView(item: NoteWithCategory) {
            binding.tvTitleNotes.text = item.note.title
            binding.tvDescNotes.text = item.note.body
            binding.tvCategoryNotes.text = item.category.categoryName
            binding.ivColorCategory.setColorFilter(Color.parseColor(item.category.hexCategoryColor))

            with(item) {
                itemView.setOnClickListener { itemClick(this) }
            }

        }
    }

}