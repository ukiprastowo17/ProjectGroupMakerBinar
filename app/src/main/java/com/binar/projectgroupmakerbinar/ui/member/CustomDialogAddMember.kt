package com.binar.projectgroupmakerbinar.ui.member

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.binar.projectgroupmakerbinar.databinding.CustomDialogAddMemberBinding

class CustomDialogAddMember() : DialogFragment() {
    private lateinit var binding: CustomDialogAddMemberBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = CustomDialogAddMemberBinding.inflate(inflater, container, false)
        binding.btSaveList.setOnClickListener {
            Toast.makeText(
                this.context,
                "Input " + binding.etMemberName.text ,
                Toast.LENGTH_SHORT
            ).show()
        }
        return binding.root
    }



}
