package com.binar.projectgroupmakerbinar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isInvisible
import androidx.viewpager2.widget.ViewPager2
import com.binar.projectgroupmakerbinar.R
import com.binar.projectgroupmakerbinar.databinding.ActivityLandingPageBinding
import com.binar.projectgroupmakerbinar.slider.SliderOneFragment
import com.binar.projectgroupmakerbinar.slider.model.SliderData
import com.binar.projectgroupmakerbinar.slider.utils.ViewPagerAdapter
import com.binar.projectgroupmakerbinar.slider.utils.getNextIndex
import com.binar.projectgroupmakerbinar.slider.utils.getPreviousIndex

class LandingPageActivity : AppCompatActivity() {
    private val binding: ActivityLandingPageBinding by lazy {
        ActivityLandingPageBinding.inflate(layoutInflater)
    }

    private val pagerAdapter: ViewPagerAdapter by lazy {
        ViewPagerAdapter(supportFragmentManager, lifecycle)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()
        initFragmentViewPager()
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        binding.tvNext.setOnClickListener {
            navigateToNextFragment()
        }
        binding.tvBack.setOnClickListener {
            navigateToBackFragment()
        }
    }

    private fun navigateToBackFragment() {
        val nextIndex = binding.vpIntro.getPreviousIndex()
        if (nextIndex != -1) {
            binding.vpIntro.setCurrentItem(nextIndex, true)
        }
    }

    private fun navigateToNextFragment() {
        val nextIndex = binding.vpIntro.getNextIndex()
        if (nextIndex != -1) {
            binding.vpIntro.setCurrentItem(nextIndex, true)
        }else{
            //Todo: navigate to Home Activity

        }
    }

    private fun initFragmentViewPager() {
        initAdapter()
        setupViewPager()
    }

    private fun initAdapter() {
        pagerAdapter.apply {
            addFragment(
                SliderOneFragment.newInstance(
                    SliderData(
                        "Easy \nTo Use",
                        "Membuat grup menjadi lebih mudah \nhanya dari ponsel Anda.",
                        R.drawable.ic_landpage_1
                    )
                )
            )
            addFragment(
                SliderOneFragment.newInstance(
                    SliderData(
                        "Fast & \nBest Solution",
                        "Sebagai sebuah solusi yang cepat dan tepat. \nAnda juga bisa memberikan nama grup.",
                        R.drawable.ic_landpage_2
                    )
                )
            )
        }
    }

    private fun setupViewPager() {
        binding.vpIntro.apply {
            adapter = pagerAdapter
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    when {
                        position == 0 -> {
                            binding.tvNext.isInvisible = false
                            binding.tvNext.isEnabled = true
                            binding.tvBack.isInvisible = true
                            binding.tvBack.isEnabled = false
                        }
                        position < pagerAdapter.getMaxIndex() -> {
                            binding.tvNext.isInvisible = false
                            binding.tvNext.isEnabled = true
                            binding.tvBack.isInvisible = false
                            binding.tvBack.isEnabled = true
                        }
                        position == pagerAdapter.getMaxIndex() -> {
                            binding.tvNext.isInvisible = false
                            binding.tvNext.isEnabled = true
                            binding.tvBack.isInvisible = false
                            binding.tvBack.isEnabled = true
                        }
                    }
                }
            })
        }
        binding.dotsIndicator.attachTo(binding.vpIntro)
    }


}