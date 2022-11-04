package com.binar.projectgroupmakerbinar.ui.member
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.binar.projectgroupmakerbinar.R
import com.binar.projectgroupmakerbinar.adapter.ListGroupListAdapter
import com.binar.projectgroupmakerbinar.data.DummyListGroupDataSource
import com.binar.projectgroupmakerbinar.data.ListGroupDataSource
import com.binar.projectgroupmakerbinar.databinding.ActivityMainBinding
import com.binar.projectgroupmakerbinar.databinding.DashboardListMemberBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
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
        setupList()
    }

    private fun setupList() {
        binding.rvListGroup.apply {
            adapter = this@MainActivity.adapter
        }
        adapter.setItemData(dataSource.getListGroup())
    }
}