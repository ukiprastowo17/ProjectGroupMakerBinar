package com.binar.projectgroupmakerbinar.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.binar.projectgroupmakerbinar.databinding.ActivityHomeBinding
import com.binar.projectgroupmakerbinar.ui.aboutpage.menu.MenuAboutActivity
import com.binar.projectgroupmakerbinar.ui.group.GroupFormActivity

class HomeActivity : AppCompatActivity() {

    private val binding: ActivityHomeBinding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.hide()
        navigateToMenu()
    }

    private fun navigateToMenu() {
        with(binding) {
            cvMember.setOnClickListener {
                val intent = Intent(this@HomeActivity, GroupFormActivity::class.java)
                startActivity(intent)
            }
            cvHistory.setOnClickListener {
//                val intent = Intent(this@HomeActivity, HistoryFormActivity::class.java)
//                startActivity(intent)
            }
            cvAbout.setOnClickListener {
                val intent = Intent(this@HomeActivity, MenuAboutActivity::class.java)
                startActivity(intent)
            }
        }
    }
}