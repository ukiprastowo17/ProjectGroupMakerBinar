package com.binar.projectgroupmakerbinar.slider.model

import android.os.Parcelable
import android.widget.ImageView
import kotlinx.parcelize.Parcelize

@Parcelize
data class SliderData(
    val title: String,
    val desc: String,
    val imgSlider: Int
): Parcelable
