package com.binar.projectgroupmakerbinar.data.room.model

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Relation
import com.binar.projectgroupmakerbinar.data.room.entity.MemberEntity
import kotlinx.parcelize.Parcelize

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
@Parcelize
data class ListGroup(
    @Embedded
    val member : MemberEntity
): Parcelable
