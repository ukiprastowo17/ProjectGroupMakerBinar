package com.binar.projectgroupmakerbinar.data.room.dao

import androidx.room.*
import com.binar.projectgroupmakerbinar.data.room.entity.ResultEntity


@Dao
interface ResultDao {

    @Query("SELECT * FROM tb_result")
    suspend fun getAllResults() : List<ResultEntity>

    @Query("SELECT * FROM tb_result WHERE id == :id")
    suspend fun getAllResultsById(id : Int) : ResultEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertResult(resultEntity: ResultEntity) : Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertResults(resultEntity: List<ResultEntity>)

    @Delete
    suspend fun deleteResult(resultEntity: ResultEntity) : Int

    @Update
    suspend fun updateResult(resultEntity: ResultEntity) : Int
}