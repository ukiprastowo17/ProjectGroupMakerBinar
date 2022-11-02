package com.binar.projectgroupmakerbinar.ui.member

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.binar.projectgroupmakerbinar.databinding.CustomDialogAddMemberBinding

class CustomDialogAddMember(name: String?) : DialogFragment() {
    private lateinit var binding: CustomDialogAddMemberBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = CustomDialogAddMemberBinding.inflate(inflater, container, false)
        return binding.root
    }

}
