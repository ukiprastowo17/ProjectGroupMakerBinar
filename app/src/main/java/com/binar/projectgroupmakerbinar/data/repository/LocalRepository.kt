package com.binar.projectgroupmakerbinar.data.repository

import com.binar.projectgroupmakerbinar.data.pref.SharedPreferenceDataSource
import com.binar.projectgroupmakerbinar.data.pref.UserPreferenceDataSource
import com.binar.projectgroupmakerbinar.data.room.dao.MemberDao
import com.binar.projectgroupmakerbinar.data.room.datasource.CategoryDataSource
import com.binar.projectgroupmakerbinar.data.room.datasource.MemberDataSource
import com.binar.projectgroupmakerbinar.data.room.datasource.NotesDataSource
import com.binar.projectgroupmakerbinar.data.room.entity.MemberEntity
import com.binar.projectgroupmakerbinar.model.ListGroup
import com.catnip.notepadku.data.room.entity.Category
import com.catnip.notepadku.data.room.entity.Note
import com.catnip.notepadku.data.room.model.NoteWithCategory
import com.catnip.notepadku.wrapper.Resource

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
interface LocalRepository {
    suspend fun getAllMember(): Resource<List<ListGroup>>
    suspend fun deleteMember(memberEntity: MemberEntity): Resource<Number>
    suspend fun insertNote(memberEntity: MemberEntity): Resource<Number>
}

class LocalRepositoryImpl(
    private val memberDataSource: MemberDataSource,
) : LocalRepository {
    override suspend fun getAllMember(): Resource<List<NoteWithCategory>> {
        return proceed { memberDataSource.getAllMembers() }
    }

    override suspend fun deleteMember(memberEntity: MemberEntity): Resource<Number> {
        return proceed { MemberDataSource.deleteMember(memberDao) }
    }

    override suspend fun insertMember(memberEntity: MemberEntity): Resource<Number> {
        return proceed { MemberDataSource.insertMember(memberEntity) }
    }


    private suspend fun <T> proceed(coroutine: suspend () -> T): Resource<T> {
        return try {
            Resource.Success(coroutine.invoke())
        } catch (exception: Exception) {
            Resource.Error(message = exception.message)
        }
    }
}