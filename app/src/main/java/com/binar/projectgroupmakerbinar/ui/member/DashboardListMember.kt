package com.binar.projectgroupmakerbinar.ui.member
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.binar.projectgroupmakerbinar.adapter.ListGroupListAdapter
import com.binar.projectgroupmakerbinar.data.DummyListGroupDataSource
import com.binar.projectgroupmakerbinar.data.ListGroupDataSource
import com.binar.projectgroupmakerbinar.databinding.DashboardListMemberBinding
import com.binar.projectgroupmakerbinar.model.ListGroup

class DashboardListMember : AppCompatActivity() {

    private val viewModel: MainViewModel by lazy {
        GenericViewModelFactory(MainViewModel(ServiceLocator.provideLocalRepository(this)))
            .create(MainViewModel::class.java)
    }

    private val binding: DashboardListMemberBinding by lazy {
        DashboardListMemberBinding.inflate(layoutInflater)
    }
    private val adapter: ListGroupListAdapter by lazy {
        ListGroupListAdapter()
    }

    private val dataSource: ListGroupDataSource by lazy {
        DummyListGroupDataSource()
    }

    private fun initData() {
        .getAllNotes()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()
        setupList()
        observeData()
        binding.apply {
            btAddList.setOnClickListener {
                CustomDialogAddList("DRAW").apply {

                }.show(supportFragmentManager, null)
            }
        }
    }

    private fun observeData() {
        viewModel.notesResult.observe(this) {
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



    private fun showData(data: List<ListGroup>?) {
        data?.let { listData ->
//            binding.pbNotes.isVisible = false
//            binding.tvError.isVisible = false
//            binding.rvNotes.isVisible = true
            if (listData.isNotEmpty()) {
                adapter.setItemData(listData)
            } else {
//                showEmptyData()
            }
        }
    }

    private fun setupList() {
        binding.rvListGroup.apply {
            adapter = this@DashboardListMember.adapter
        }
        adapter.setItemData(dataSource.getListGroup())
    }
}