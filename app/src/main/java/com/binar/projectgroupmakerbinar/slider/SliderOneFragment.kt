package com.binar.projectgroupmakerbinar.slider

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import com.binar.projectgroupmakerbinar.R
import com.binar.projectgroupmakerbinar.databinding.FragmentSliderOneBinding
import com.binar.projectgroupmakerbinar.slider.model.SliderData


class SliderOneFragment : Fragment() {
    private lateinit var binding: FragmentSliderOneBinding

    private var sliderData: SliderData? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSliderOneBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindSliderData()
    }

    private fun bindSliderData() {
        with(binding){
            tvTitleLandpage.text = sliderData?.title.orEmpty()
            tvDescLandpage.text = sliderData?.desc.orEmpty()
            ivLandpage.load(sliderData?.imgSlider){
                crossfade(true)
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            sliderData = it.getParcelable(ARG_SLIDER_DATA)
        }
    }

    companion object {
        const val ARG_SLIDER_DATA = "ARG_SLIDER_DATA"

        @JvmStatic
        fun newInstance(sliderData: SliderData) =
            SliderOneFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_SLIDER_DATA,sliderData)

                }
            }
    }
}