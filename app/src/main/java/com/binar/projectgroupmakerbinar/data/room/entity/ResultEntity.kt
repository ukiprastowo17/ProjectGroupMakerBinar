package com.binar.projectgroupmakerbinar.data.room.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "tb_result")
data class ResultEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int? = null,

    @ColumnInfo( name = "resultData")
    val resultData: String,

    ) : Parcelable
