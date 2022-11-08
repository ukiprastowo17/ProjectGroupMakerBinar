package com.binar.projectgroupmakerbinar.data.room.dao

import androidx.room.*
import com.binar.projectgroupmakerbinar.data.room.entity.MemberEntity


@Dao
interface MemberDao {

    @Query("SELECT * FROM tb_member WHERE `group`= :group ")
    suspend fun getAllMembers(group: String) : List<MemberEntity>

    @Query("SELECT * FROM tb_member GROUP BY `group`")
    suspend fun getAllGroup() : List<MemberEntity>


    @Query("SELECT * FROM tb_member WHERE id == :id")
    suspend fun getAllMembersById(id : Int) : MemberEntity

    @Query("DELETE FROM tb_member WHERE `group` = :groupNa")
    suspend fun deleteGroup(groupNa: String)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMember(memberEntity: MemberEntity) : Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMembers(memberEntity: List<MemberEntity>)

    @Delete
    suspend fun deleteMember(memberEntity: MemberEntity) : Int

    @Update
    suspend fun updateMember(memberEntity: MemberEntity) : Int
}