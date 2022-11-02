package com.binar.projectgroupmakerbinar.ui.member
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.binar.projectgroupmakerbinar.adapter.ListGroupListAdapter
import com.binar.projectgroupmakerbinar.data.DummyListGroupDataSource
import com.binar.projectgroupmakerbinar.data.ListGroupDataSource
import com.binar.projectgroupmakerbinar.databinding.DashboardListMemberBinding

class DashboardListMember : AppCompatActivity() {
    private val binding: DashboardListMemberBinding by lazy {
        DashboardListMemberBinding.inflate(layoutInflater)
    }
    private val adapter: ListGroupListAdapter by lazy {
        ListGroupListAdapter()
    }

    private val dataSource: ListGroupDataSource by lazy {
        DummyListGroupDataSource()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()
        setupList()
        binding.apply {
            btAddList.setOnClickListener {
                CustomDialogAddList("DRAW").apply {

                }.show(supportFragmentManager, null)
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