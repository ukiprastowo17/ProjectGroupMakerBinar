package com.binar.projectgroupmakerbinar.ui.about

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.binar.projectgroupmakerbinar.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private val binding: ActivityAboutBinding by lazy {
        ActivityAboutBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()
    }
}