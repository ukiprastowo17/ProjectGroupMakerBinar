package com.binar.projectgroupmakerbinar.history

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.binar.projectgroupmakerbinar.R
import com.binar.projectgroupmakerbinar.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity() {
    private val binding: ActivityHistoryBinding by lazy {
        ActivityHistoryBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }


}