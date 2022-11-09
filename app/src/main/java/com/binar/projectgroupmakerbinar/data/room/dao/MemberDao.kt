package com.binar.projectgroupmakerbinar.data.room.dao

import androidx.room.*
import com.binar.projectgroupmakerbinar.constant.CommonConstant
import com.binar.projectgroupmakerbinar.data.room.entity.Member
import com.binar.projectgroupmakerbinar.data.room.entity.MemberEntity


@Dao
interface MemberDao {

    @Query("SELECT * FROM " + CommonConstant.DATABASE_TABLE)
    suspend fun getAllMember() : List<Member>


    @Query("SELECT * FROM " + CommonConstant.DATABASE_TABLE + " WHERE "+ CommonConstant.KEY_ROWID +" == :id")
    suspend fun getAllMembersById(id : Int) : Member

    @Query("SELECT * FROM " + CommonConstant.DATABASE_TABLE + " WHERE "+  CommonConstant.KEY_NAME_MEMBER +" == :id")
    suspend fun getPlayersByPreset(id : String) : List<Member>

    @Query("SELECT * FROM " + CommonConstant.DATABASE_TABLE+ " where " + CommonConstant.KEY_ID_GROUP + "== :id")
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