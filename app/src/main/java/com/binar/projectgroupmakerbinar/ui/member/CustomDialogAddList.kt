package com.binar.projectgroupmakerbinar.ui.member

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.binar.projectgroupmakerbinar.base.GenericViewModelFactory
import com.binar.projectgroupmakerbinar.data.repository.LocalRepository
import com.binar.projectgroupmakerbinar.data.room.entity.MemberEntity
import com.binar.projectgroupmakerbinar.databinding.CustomDialogAddListBinding
import com.binar.projectgroupmakerbinar.di.ServiceLocator
import kotlinx.coroutines.launch

class CustomDialogAddList() : DialogFragment() {
    private lateinit var binding: CustomDialogAddListBinding

//    private val viewModel: listViewModel by lazy {
//        GenericViewModelFactory(listViewModel(ServiceLocator.provideLocalRepository(this)))
//            .create(listViewModel::class.java)
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = CustomDialogAddListBinding.inflate(inflater, container, false)
//        binding.btSaveList.setOnClickListener {
//            Toast.makeText(
//                this.context,
//                "Input " + binding.etListName.text ,
//                Toast.LENGTH_SHORT
//            ).show()
//        }
//        val listName = binding.etListName.text.toString()
//        val notesNa = binding.etNotes.text.toString()
        return binding.root
    }
}


class listViewModel(private val repository: LocalRepository) : ViewModel() {

    fun insert(memberEntity: MemberEntity) = viewModelScope.launch {
        repository.insertMember(memberEntity)
    }
}