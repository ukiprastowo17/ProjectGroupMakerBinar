package com.binar.projectgroupmakerbinar.data.room.dao

import androidx.room.*


import com.binar.projectgroupmakerbinar.constant.CommonConstant
import com.binar.projectgroupmakerbinar.data.room.entity.Member

@Dao
interface MemberDao {

    @Query("SELECT * FROM " + CommonConstant.DATABASE_TABLE + " ORDER BY " + CommonConstant.KEY_ROWID + " DESC")
    suspend fun getAllMember() : List<Member>


    @Query("SELECT * FROM " + CommonConstant.DATABASE_TABLE + " WHERE "+ CommonConstant.KEY_ROWID +" == :id" + " ORDER BY " + CommonConstant.KEY_ROWID + " DESC")
    suspend fun getAllMembersById(id : Int) : Member


    @Query("SELECT * FROM " + CommonConstant.DATABASE_TABLE+ " where " + CommonConstant.KEY_ID_GROUP + "== :id" + " ORDER BY " + CommonConstant.KEY_ROWID + " DESC")
    suspend fun getAllGroupByGroup(id: String) : List<Member>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMember(member: Member) : Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMembers(member: List<Member>)

    @Delete
    suspend fun deleteMember(member: Member) : Int

    @Update
    suspend fun updateMember(member: Member) : Int

}