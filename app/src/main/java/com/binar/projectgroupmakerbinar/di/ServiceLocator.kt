package com.binar.projectgroupmakerbinar.di

import android.content.Context
import com.binar.projectgroupmakerbinar.data.AppDatabase
import com.binar.projectgroupmakerbinar.data.repository.LocalRepository
import com.binar.projectgroupmakerbinar.data.repository.LocalRepositoryImpl
import com.binar.projectgroupmakerbinar.data.room.dao.GroupDao
import com.binar.projectgroupmakerbinar.data.room.datasource.GroupDataSource
import com.binar.projectgroupmakerbinar.data.room.datasource.GroupDataSourceImpl

object ServiceLocator {
    fun provideAppDatabase(context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    fun provideGroupDao(context: Context): GroupDao {
        return provideAppDatabase(context).groupDao()
    }

    fun provideGroupDataSource(context: Context): GroupDataSource {
        return GroupDataSourceImpl(provideGroupDao(context))
    }

    fun provideLocalRepository(context: Context): LocalRepository {
        return LocalRepositoryImpl(
            provideGroupDataSource(context)

        )
    }
}