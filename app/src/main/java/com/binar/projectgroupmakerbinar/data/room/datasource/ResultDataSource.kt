package com.binar.projectgroupmakerbinar.data.room.datasource

import com.binar.projectgroupmakerbinar.data.room.dao.ResultDao
import com.binar.projectgroupmakerbinar.data.room.entity.ResultEntity


interface ResultDataSource {
    suspend fun getAllResults(): List<ResultEntity>

    suspend fun getAllResultsById(id: Int): ResultEntity


    suspend fun insertResult(resultEntity: ResultEntity): Long

    suspend fun insertResult(resultEntity:  List<ResultEntity>)

    suspend fun deleteResult(resultEntity: ResultEntity): Int

    suspend fun updateResult(resultEntity: ResultEntity): Int
}

class ResultDataSourceImpl(private val dao: ResultDao) : ResultDataSource {
    override suspend fun getAllResults(): List<ResultEntity> {
        return dao.getAllResults()
    }

    override suspend fun getAllResultsById(id: Int): ResultEntity {
        return dao.getAllResultsById(id)
    }

    override suspend fun insertResult(resultEntity: ResultEntity): Long {
        return dao.insertResult(resultEntity)
    }

    override suspend fun insertResult(resultEntity: List<ResultEntity>) {
        return dao.insertResults(resultEntity)
    }

    override suspend fun deleteResult(resultEntity: ResultEntity): Int {
        return dao.deleteResult(resultEntity)
    }

    override suspend fun updateResult(resultEntity: ResultEntity): Int {
        return dao.updateResult(resultEntity)
    }


}