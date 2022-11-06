package com.binar.projectgroupmakerbinar.ui.team

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.binar.projectgroupmakerbinar.databinding.ActivityTeamBinding
import com.binar.projectgroupmakerbinar.ui.about.AboutActivity
import com.binar.projectgroupmakerbinar.ui.profile.*

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
        binding.llUki.setOnClickListener  {
            val intent = Intent(this, ProfileUkiActivity::class.java)
            startActivity(intent)
            Toast.makeText(this@TeamActivity,"Leader of Us",Toast.LENGTH_SHORT).show()
        }
        binding.llLukas.setOnClickListener {
            val intent = Intent(this,ProfileLukasActivity::class.java)
            startActivity(intent)
            Toast.makeText(this@TeamActivity,"Design of Us",Toast.LENGTH_SHORT).show()
        }
        binding.llAdhi.setOnClickListener {
            val intent = Intent(this,ProfileAdhiActivity::class.java)
            startActivity(intent)
            Toast.makeText(this@TeamActivity,"Scrum of Us",Toast.LENGTH_SHORT).show()
        }
        binding.llRodan.setOnClickListener {
            val intent = Intent(this,ProfileRodanActivity::class.java)
            startActivity(intent)
            Toast.makeText(this@TeamActivity,"Developer of Us",Toast.LENGTH_SHORT).show()
        }
        binding.llHabio.setOnClickListener {
            val intent = Intent(this,ProfileHabioActivity::class.java)
            startActivity(intent)
            Toast.makeText(this@TeamActivity,"Developer of Us",Toast.LENGTH_SHORT).show()
        }
        binding.llEri.setOnClickListener {
            val intent = Intent(this,ProfileEriActivity::class.java)
            startActivity(intent)
            Toast.makeText(this@TeamActivity,"Developer of Us",Toast.LENGTH_SHORT).show()
        }
    }
}