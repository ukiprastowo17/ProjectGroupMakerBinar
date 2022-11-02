package com.binar.projectgroupmakerbinar.ui.member

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.binar.projectgroupmakerbinar.R
import com.binar.projectgroupmakerbinar.databinding.DashboardListMemberBinding

class DashboardListMember : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard_list_member)
        supportActionBar?.hide()
    }
}