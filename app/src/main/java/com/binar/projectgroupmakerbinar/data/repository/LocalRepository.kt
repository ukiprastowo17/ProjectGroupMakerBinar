package com.binar.projectgroupmakerbinar.data.repository

import com.binar.projectgroupmakerbinar.data.room.datasource.GroupDataSource
import com.binar.projectgroupmakerbinar.data.room.entity.Group
import com.binar.projectgroupmakerbinar.wraper.Resource

interface LocalRepository {

    suspend fun getAllGroups(): Resource<List<Group>>
    suspend fun deleteGroup(group: Group): Resource<Number>
    suspend fun updateGroup(group: Group): Resource<Number>
    suspend fun insertGroup(group: Group): Resource<Number>

}

class LocalRepositoryImpl(
    private val groupDataSource: GroupDataSource

) : LocalRepository {

    override suspend fun getAllGroups(): Resource<List<Group>> {
        return proceed { groupDataSource.getAllGroup() }
    }

    override suspend fun deleteGroup(group: Group): Resource<Number> {
        return proceed { groupDataSource.deleteGroup(group) }
    }

    override suspend fun updateGroup(group: Group): Resource<Number> {
        return proceed { groupDataSource.updateGroup(group) }
    }

    override suspend fun insertGroup(group: Group): Resource<Number> {
        return proceed { groupDataSource.insertGroup(group) }
    }

    private suspend fun <T> proceed(coroutine: suspend () -> T): Resource<T> {
        return try {
            Resource.Success(coroutine.invoke())
        } catch (exception: Exception) {
            Resource.Error(message = exception.message)
        }
    }
}