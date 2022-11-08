package com.binar.projectgroupmakerbinar.ui.member
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.binar.projectgroupmakerbinar.base.GenericViewModelFactory
import com.binar.projectgroupmakerbinar.data.DummyMemberDataSource
import com.binar.projectgroupmakerbinar.data.ListMemberDataSource
import com.binar.projectgroupmakerbinar.data.repository.LocalRepository
import com.binar.projectgroupmakerbinar.data.room.entity.MemberEntity
import com.binar.projectgroupmakerbinar.databinding.AddMemberBinding
import com.binar.projectgroupmakerbinar.di.ServiceLocator
import com.binar.projectgroupmakerbinar.ui.main.adapter.ListMembersAdapter
import com.catnip.notepadku.wrapper.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AddMember : AppCompatActivity() {

    private val binding: AddMemberBinding by lazy {
        AddMemberBinding.inflate(layoutInflater)
    }

    private val viewModel: MemberViewModel by lazy {
        GenericViewModelFactory(MemberViewModel(ServiceLocator.provideLocalRepositoryAddMember(this)))
            .create(MemberViewModel::class.java)
    }

    private fun initData (groupNa: String) {
        viewModel.getAllMember(groupNa)
    }


    private val adapter: ListMembersAdapter by lazy {
        ListMembersAdapter {
            //todo : onClick event
        }
    }

    private val dataSource: ListMemberDataSource by lazy {
        DummyMemberDataSource()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val groupName = intent.getStringExtra("GROUPNAME").toString()
        supportActionBar?.hide()
        initRecyclerView()
        observeData()
        initData(groupName)

        binding.apply {
            tvMemberCaption.text = groupName
            btAddMember.setOnClickListener {
                CustomDialogAddMember().apply {
                }.show(supportFragmentManager, null)
            }
        }
    }


    private fun observeData() {
        viewModel.memberResult.observe(this) {
            when (it) {
                is Resource.Error -> {
                    showError(it.message)
                }
                is Resource.Loading -> {
                    showLoading()
                }
                is Resource.Success -> {
                    showData(it.data)
                }
            }
        }
    }

    private fun showData(data: List<MemberEntity>?) {
        data?.let { listData ->
            if (listData.isNotEmpty()) {
                adapter.setItems(listData)
            } else {
                showEmptyData()
            }
        }
    }

    private fun showEmptyData() {

    }

    private fun initRecyclerView() {
        binding.rvMember.adapter = this@AddMember.adapter
    }

    private fun showLoading() {

    }

    private fun showError(message: String?) {

    }
}

typealias ListMemberResultType = Resource<List<MemberEntity>>
class MemberViewModel(private val repository: LocalRepository) : ViewModel() {
    val memberResult  = MutableLiveData<ListMemberResultType>()

    fun getAllMember(groupNa: String){
        viewModelScope.launch (Dispatchers.IO){
            memberResult.postValue(Resource.Loading())
            delay(1000)
            memberResult.postValue(repository.getAllMember(groupNa))
        }
    }
}