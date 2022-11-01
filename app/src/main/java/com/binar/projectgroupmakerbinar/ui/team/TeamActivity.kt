package com.binar.projectgroupmakerbinar.ui.team

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.binar.projectgroupmakerbinar.databinding.ActivityTeamBinding

class TeamActivity : AppCompatActivity() {
    private val binding: ActivityTeamBinding by lazy {
        ActivityTeamBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()
        setTeamClickListener()
    }

    private fun setTeamClickListener(){
        binding.ivLeader.setOnClickListener {
            Toast.makeText(this@TeamActivity,"Leader of Us",Toast.LENGTH_SHORT).show()
        }
        binding.ivDesign.setOnClickListener {
            Toast.makeText(this@TeamActivity,"Design of Us",Toast.LENGTH_SHORT).show()
        }
        binding.ivScrum.setOnClickListener {
            Toast.makeText(this@TeamActivity,"Scrum of Us",Toast.LENGTH_SHORT).show()
        }
        binding.ivDeveloper1.setOnClickListener {
            Toast.makeText(this@TeamActivity,"Developer of Us",Toast.LENGTH_SHORT).show()
        }
        binding.ivDeveloper2.setOnClickListener {
            Toast.makeText(this@TeamActivity,"Developer of Us",Toast.LENGTH_SHORT).show()
        }
        binding.ivDeveloper3.setOnClickListener {
            Toast.makeText(this@TeamActivity,"Developer of Us",Toast.LENGTH_SHORT).show()
        }
    }
}