package com.binar.projectgroupmakerbinar.ui.member

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.binar.projectgroupmakerbinar.databinding.CustomDialogDeleteMemberBinding

class CustomDialogDeleteMember() : DialogFragment() {
    private lateinit var binding: CustomDialogDeleteMemberBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = CustomDialogDeleteMemberBinding.inflate(inflater, container, false)
        return binding.root
    }


}
