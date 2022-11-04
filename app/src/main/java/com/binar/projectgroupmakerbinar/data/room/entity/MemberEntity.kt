package com.binar.projectgroupmakerbinar.data.room.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "tb_member")
data class MemberEntity(
    @PrimaryKey(autoGenerate = false) val id: Int? = null,
    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "note")
    val note: String,

    @ColumnInfo(name = "group")
    val group: String
) : Parcelable
