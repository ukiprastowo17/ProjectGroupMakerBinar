package com.binar.projectgroupmakerbinar.di

import android.content.Context
import com.binar.projectgroupmakerbinar.data.pref.SharedPreference
import com.binar.projectgroupmakerbinar.data.pref.SharedPreferenceDataSource
import com.binar.projectgroupmakerbinar.data.pref.SharedPreferenceDataSourceImpl
import com.binar.projectgroupmakerbinar.data.repository.LocalRepository
import com.binar.projectgroupmakerbinar.data.repository.LocalRepositoryImpl
import com.binar.projectgroupmakerbinar.data.room.AppDatabase
import com.binar.projectgroupmakerbinar.data.room.dao.MemberDao
import com.binar.projectgroupmakerbinar.data.room.datasource.*

object ServiceLocator {

    fun provideUserPreference(context: Context): SharedPreference {
        return SharedPreference(context)
    }

    fun provideAppDatabase(context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    fun provideMemberDao(context: Context): MemberDao {
        return provideAppDatabase(context).memberDao()
    }

    fun provideNotesDataSource(context: Context): MemberDataSource {
        return MemberDataSourceImpl(provideMemberDao(context))
    }

    fun provideUserPreferenceDataSource(context: Context): SharedPreferenceDataSource {
        return SharedPreferenceDataSourceImpl(provideUserPreference(context))
    }

    fun provideLocalRepository(context: Context): LocalRepository {
        return LocalRepositoryImpl(
            provideNotesDataSource(context)
        )
    }


}