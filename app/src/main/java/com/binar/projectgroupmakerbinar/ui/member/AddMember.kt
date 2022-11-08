package com.binar.projectgroupmakerbinar.ui.member
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.binar.projectgroupmakerbinar.adapter.ListMemberListAdapter
import com.binar.projectgroupmakerbinar.data.DummyMemberDataSource
import com.binar.projectgroupmakerbinar.data.ListMemberDataSource
import com.binar.projectgroupmakerbinar.databinding.AddMemberBinding

class AddMember : AppCompatActivity() {
    private val binding: AddMemberBinding by lazy {
        AddMemberBinding.inflate(layoutInflater)
    }
    private val adapter: ListMemberListAdapter by lazy {
        ListMemberListAdapter()
    }

    private val dataSource: ListMemberDataSource by lazy {
        DummyMemberDataSource()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide() ;
        setupList()
        binding.apply {
            btAddMember.setOnClickListener {
                CustomDialogAddMember("DRAW").apply {

                }.show(supportFragmentManager, null)
            }
        }
    }

    private fun setupList() {
        binding.rvMember.apply {
            adapter = this@AddMember.adapter
        }
        adapter.setItemData(dataSource.getListMember())
    }
}