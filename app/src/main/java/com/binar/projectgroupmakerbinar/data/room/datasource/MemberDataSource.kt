package com.binar.projectgroupmakerbinar.data.room.datasource

import com.binar.projectgroupmakerbinar.data.room.dao.MemberDao
import com.binar.projectgroupmakerbinar.data.room.entity.MemberEntity


interface MemberDataSource {
    suspend fun getAllMembers(): List<MemberEntity>

    suspend fun getAllMembersById(id: Int): MemberEntity


    suspend fun insertMember(memberEntity: MemberEntity): Long

    suspend fun insertMembers(memberEntity: List<MemberEntity>)

    suspend fun deleteMember(memberEntity: MemberEntity): Int

    suspend fun updateMember(memberEntity: MemberEntity): Int
}

class MemberDataSourceImpl(private val dao: MemberDao) : MemberDataSource {
    override suspend fun getAllMembers(): List<MemberEntity> {
        return dao.getAllMembers()
    }

    override suspend fun getAllMembersById(id: Int): MemberEntity {
       return dao.getAllMembersById(id)
    }

    override suspend fun insertMember(memberEntity: MemberEntity): Long {
        return dao.insertMember(memberEntity)
    }

    override suspend fun insertMembers(memberEntity: List<MemberEntity>) {
        return dao.insertMembers(memberEntity)
    }

    override suspend fun deleteMember(memberEntity: MemberEntity): Int {
        return dao.deleteMember(memberEntity)
    }

    override suspend fun updateMember(memberEntity: MemberEntity): Int {
        return dao.updateMember(memberEntity)
    }


}