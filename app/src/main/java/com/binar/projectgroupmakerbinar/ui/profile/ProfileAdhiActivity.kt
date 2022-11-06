package com.binar.projectgroupmakerbinar.ui.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.binar.projectgroupmakerbinar.R

class ProfileAdhiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_adhi)
        supportActionBar?.hide()
    }
}