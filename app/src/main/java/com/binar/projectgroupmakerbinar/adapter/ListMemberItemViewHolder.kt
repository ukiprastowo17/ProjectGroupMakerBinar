package com.binar.projectgroupmakerbinar.adapter

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.binar.projectgroupmakerbinar.databinding.CustomDialogDeleteMemberBinding
import com.binar.projectgroupmakerbinar.databinding.ItemMembersBinding
import com.binar.projectgroupmakerbinar.model.ListMember

open class ListMemberItemViewHolder(private val binding: ItemMembersBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindView(item: ListMember) {
        binding.tvListTitle.text = item.memberName
        binding.btDeleteMember.setOnClickListener {
            CustomDialogDeleteMember2().showDialog()
        }
    }
}

class CustomDialogDeleteMember2() : AppCompatActivity() {
    private var dialog: Dialog? = null

    private val bindingDialog: CustomDialogDeleteMemberBinding by lazy {
        CustomDialogDeleteMemberBinding.inflate(layoutInflater)
    }

    fun showDialog() {
        dialog!!.setContentView(bindingDialog.root)
//        dialog!!.setCancelable(false);
//        bindingDialog.tvResult.text = gameEngine.returnGame(scoreFinal, scoreFinalP2)
//        bindingDialog.tvInfoScore.text =  getString( R.string.score_final_label, name.toString(), scoreFinal.toString(), gameEngine.playerNameEnemy(isUsingMultiplayerMode) , scoreFinalP2.toString() )
//        bindingDialog.btRestart.setOnClickListener(View.OnClickListener {
//            dialog!!.dismiss()
//            restart()
//        })
//        bindingDialog.btMenuBack.setOnClickListener(View.OnClickListener {
//            finish()
//        })

        dialog!!.show()
    }
}