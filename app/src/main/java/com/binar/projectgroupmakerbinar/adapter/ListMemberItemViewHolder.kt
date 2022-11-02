package com.binar.projectgroupmakerbinar.adapter

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.binar.projectgroupmakerbinar.databinding.ItemMembersBinding
import com.binar.projectgroupmakerbinar.model.ListMember
import com.binar.projectgroupmakerbinar.ui.member.AddMember
import com.binar.projectgroupmakerbinar.ui.member.CustomDialogDeleteMember

class ListMemberItemViewHolder(private val binding: ItemMembersBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bindView(item: ListMember) {
        // first create the dialog
        binding.tvListTitle.text = item.memberName
//        binding.btDeleteMember.setOnClickListener {
//            CustomDialogDeleteMember().apply { }.show(FragmentActivity,null)
//            Toast.makeText(itemView.context, item.memberName, Toast.LENGTH_SHORT).show()
//        }

        binding.btDeleteMember.setOnClickListener {
            val dialog = android.app.AlertDialog.Builder(itemView.context)
            dialog.setTitle("Hasil Permainan")
            dialog.setMessage("menang")
//    dialog.setIcon(R.drawable.ic_permainan)
            dialog.setCancelable(false)
            dialog.setPositiveButton("MAIN LAGI") { dialogInterface, p1 ->

            }
            dialog.setNegativeButton("KEMBALI KE MENU") { dialogInterface, p1 ->
//        Intent(this, OptionsActivity::class.java).also {
//            it.putExtra("PLAYERNAME", playerOneName)
//            startActivity(it)
//        }
            }
            dialog.show()
//            CustomDialogDeleteMember().apply { }.show(FragmentManager,null)
        }
    }
}