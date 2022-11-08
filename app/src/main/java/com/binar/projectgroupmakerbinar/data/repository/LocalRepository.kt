package com.binar.projectgroupmakerbinar.data.repository

import com.binar.projectgroupmakerbinar.data.room.datasource.MemberDataSource
import com.binar.projectgroupmakerbinar.data.room.entity.MemberEntity
import com.binar.projectgroupmakerbinar.data.room.model.ListGroup
import com.catnip.notepadku.wrapper.Resource
import java.lang.reflect.Member

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
interface LocalRepository {
    suspend fun getAllMember(): Resource<List<MemberEntity>>
    suspend fun getAllGroup(): Resource<List<MemberEntity>>
    suspend fun deleteMember(memberEntity: MemberEntity): Resource<Number>
    suspend fun insertMember(memberEntity: MemberEntity): Resource<Number>
}

class LocalRepositoryImpl(
    private val memberDataSource: MemberDataSource,
) : LocalRepository {
    override suspend fun getAllMember(): Resource<List<MemberEntity>> {
        return proceed { memberDataSource.getAllMembers()}
    }

    override suspend fun getAllGroup(): Resource<List<MemberEntity>> {
        return proceed { memberDataSource.getAllGroup()}
    }

    override suspend fun deleteMember(memberEntity: MemberEntity): Resource<Number> {
        return proceed { memberDataSource.deleteMember(memberEntity) }
    }

    override suspend fun insertMember(memberEntity: MemberEntity): Resource<Number> {
        return proceed { memberDataSource.insertMember(memberEntity) }
    }

    private suspend fun <T> proceed(coroutine: suspend () -> T): Resource<T> {
        return try {
            Resource.Success(coroutine.invoke())
        } catch (exception: Exception) {
            Resource.Error(message = exception.message)
        }
    }
}