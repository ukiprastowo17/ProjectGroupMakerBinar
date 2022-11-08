package com.binar.projectgroupmakerbinar.ui.member
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.binar.projectgroupmakerbinar.base.GenericViewModelFactory
import com.binar.projectgroupmakerbinar.data.DummyListGroupDataSource
import com.binar.projectgroupmakerbinar.data.ListGroupDataSource
import com.binar.projectgroupmakerbinar.data.repository.LocalRepository
import com.binar.projectgroupmakerbinar.data.room.entity.MemberEntity
import com.binar.projectgroupmakerbinar.databinding.DashboardListMemberBinding
import com.binar.projectgroupmakerbinar.di.ServiceLocator
import com.binar.projectgroupmakerbinar.ui.main.adapter.MembersAdapter
import com.catnip.notepadku.wrapper.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class DashboardListMember : AppCompatActivity() {

    private val binding: DashboardListMemberBinding by lazy {
        DashboardListMemberBinding.inflate(layoutInflater)
    }

    private val viewModel: MainViewModel by lazy {
        GenericViewModelFactory(MainViewModel(ServiceLocator.provideLocalRepository(this)))
            .create(MainViewModel::class.java)
    }


    private fun initData() {
        viewModel.getAllGroup()
    }

    private val adapter: MembersAdapter by lazy {
        MembersAdapter {
            //todo : onClick event
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()
        initRecyclerView()
        observeData()
        initData()
        binding.apply {
            btAddList.setOnClickListener {
                CustomDialogAddList().apply {

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
//        binding.tvError.isVisible = true
//        binding.tvError.text = getString(R.string.text_empty_notes)

    }

    private fun initRecyclerView() {
        binding.rvListGroup.adapter = this@DashboardListMember.adapter
    }

    private fun showLoading() {
//        binding.pbNotes.isVisible = true
//        binding.tvError.isVisible = false
//        binding.rvNotes.isVisible = false
    }

    private fun showError(message: String?) {
//        binding.pbNotes.isVisible = false
//        binding.tvError.isVisible = true
//        binding.rvNotes.isVisible = false
//        message?.let {
//            binding.tvError.text = it
//        }
    }



}

typealias MemberResultType = Resource<List<MemberEntity>>
class MainViewModel(private val repository: LocalRepository) : ViewModel() {
    val memberResult  = MutableLiveData<MemberResultType>()

    fun getAllGroup(){
        viewModelScope.launch (Dispatchers.IO){
            memberResult.postValue(Resource.Loading())
            delay(1000)
            memberResult.postValue(repository.getAllGroup())
        }
    }
}