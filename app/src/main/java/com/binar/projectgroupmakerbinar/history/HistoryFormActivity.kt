package com.binar.projectgroupmakerbinar.history

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.view.isVisible
import com.binar.projectgroupmakerbinar.R
import com.binar.projectgroupmakerbinar.base.BaseActivity
import com.binar.projectgroupmakerbinar.base.GenericViewModelFactory
import com.binar.projectgroupmakerbinar.constant.CommonConstant
import com.binar.projectgroupmakerbinar.data.room.entity.Member
import com.binar.projectgroupmakerbinar.databinding.ActivityHistoryFormBinding
import com.binar.projectgroupmakerbinar.di.ServiceLocator
import com.binar.projectgroupmakerbinar.history.adapter.HistoryAdapter
import com.binar.projectgroupmakerbinar.history.viewmodel.HistoryViewModel
import com.binar.projectgroupmakerbinar.model.ResultModel
import com.binar.projectgroupmakerbinar.wrapper.Resource

class HistoryFormActivity : BaseActivity<ActivityHistoryFormBinding>(ActivityHistoryFormBinding::inflate) {

    private val viewModel: HistoryViewModel by lazy {
        GenericViewModelFactory(HistoryViewModel(ServiceLocator.provideLocalRepository(this))).create(
            HistoryViewModel::class.java
        )
    }

    var playersArrList: ArrayList<String>? = null

    private val idGroup: String? by lazy {
        intent.getStringExtra("id_group")
    }

    private val adapter: HistoryAdapter by lazy {
        HistoryAdapter {
            val intent = Intent(this@HistoryFormActivity, HistoryDetailFormActivity::class.java)
            intent.putExtra("name_result", it.name_result)
            startActivity(intent)
            Toast.makeText(this@HistoryFormActivity, "Go To About Activity", Toast.LENGTH_SHORT)
                .show()
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.setIntentData(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        playersArrList = ArrayList()
        initRecyclerView()
        observeData()
        initData()
    }

    private fun initData() {
        Log.d("datagroup",idGroup.toString())
        viewModel.getAllResult()
    }

    private fun observeData() {
        viewModel.initialDataResultHistory.observe(this) {
            when (it) {
                is Resource.Error -> {
                    showError(it.message)
                }
                is Resource.Loading -> {
                    showLoading()
                }
                is Resource.Success -> {
                    showData(it.data)
                }
            }
        }

        viewModel.insertResult.observe(this) {
            when (it) {
                is Resource.Loading -> {
                    binding.pbForm.isVisible = true
                }
                is Resource.Success -> {
                    binding.pbForm.isVisible = false
//                    finish()
                    initData()
                    Toast.makeText(this, "Insert data Success", Toast.LENGTH_SHORT).show()
                }
                is Resource.Error -> {
                    binding.pbForm.isVisible = false
//                    finish()
                    Toast.makeText(this, "Error when update data", Toast.LENGTH_SHORT).show()
                }
            }
        }
        viewModel.updateResult.observe(this) {
            when (it) {
                is Resource.Loading -> {
                    binding.pbForm.isVisible = true
                }
                is Resource.Success -> {
                    binding.pbForm.isVisible = false
                    finish()
                    Toast.makeText(this, "Update data Success", Toast.LENGTH_SHORT).show()
                }
                is Resource.Error -> {
                    binding.pbForm.isVisible = false
                    finish()
                    Toast.makeText(this, "Error when update data", Toast.LENGTH_SHORT).show()
                }
            }
        }
        viewModel.deleteResult.observe(this) {
            when (it) {
                is Resource.Loading -> {
                    binding.pbForm.isVisible = true
                }
                is Resource.Success -> {
                    binding.pbForm.isVisible = false
                    finish()
                    Toast.makeText(this, "Delete data Success", Toast.LENGTH_SHORT).show()
                }
                is Resource.Error -> {
                    binding.pbForm.isVisible = false
                    finish()
                    Toast.makeText(this, "Error when delete data", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }



    private fun showData(data: List<ResultModel>?) {
        data?.let { listData ->
            binding.pbForm.isVisible = false
            binding.tvError.isVisible = false
            binding.rvNotes.isVisible = true
            if (listData.isNotEmpty()) {
                adapter.setItems(listData)
            } else {
                showEmptyData()
            }
        }
    }

    private fun showEmptyData() {
        binding.tvError.isVisible = true
        binding.tvError.text = getString(R.string.text_empty_notes)

    }

    private fun showLoading() {
        binding.pbForm.isVisible = true
        binding.tvError.isVisible = false
        binding.rvNotes.isVisible = false
    }

    private fun showError(message: String?) {
        binding.pbForm.isVisible = false
        binding.tvError.isVisible = true
        binding.rvNotes.isVisible = false
        message?.let {
            binding.tvError.text = it
        }
    }

    private fun initRecyclerView() {
        binding.rvNotes.adapter = this@HistoryFormActivity.adapter
    }
}