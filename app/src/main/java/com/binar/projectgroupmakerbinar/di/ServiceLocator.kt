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
import com.binar.projectgroupmakerbinar.ui.main.adapter.MembersAdapter
import com.binar.projectgroupmakerbinar.ui.member.AddMember
import com.binar.projectgroupmakerbinar.ui.member.CustomDialogAddMember
import com.binar.projectgroupmakerbinar.ui.member.DashboardListMember

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

    fun provideMemberDataSource(context: Context): MemberDataSource {
        return MemberDataSourceImpl(provideMemberDao(context))
    }


    fun provideLocalRepository(context: DashboardListMember): LocalRepository {
        return LocalRepositoryImpl(
            provideMemberDataSource(context)
        )
    }

    fun provideLocalRepositoryAddMember(context: AddMember): LocalRepository {
        return LocalRepositoryImpl(
            provideMemberDataSource(context)
        )
    }
    
}