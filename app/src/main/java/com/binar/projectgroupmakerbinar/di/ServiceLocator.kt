package com.binar.projectgroupmakerbinar.di

import android.content.Context
import com.binar.projectgroupmakerbinar.data.pref.UserPreference
import com.binar.projectgroupmakerbinar.data.pref.UserPreferenceDataSource
import com.binar.projectgroupmakerbinar.data.pref.UserPreferenceDataSourceImpl
import com.binar.projectgroupmakerbinar.data.repository.LocalRepository
import com.binar.projectgroupmakerbinar.data.repository.LocalRepositoryImpl
import com.binar.projectgroupmakerbinar.data.room.AppDatabase
import com.binar.projectgroupmakerbinar.data.room.dao.CategoriesDao
import com.binar.projectgroupmakerbinar.data.room.dao.NotesDao
import com.binar.projectgroupmakerbinar.data.room.datasource.CategoryDataSource
import com.binar.projectgroupmakerbinar.data.room.datasource.CategoryDataSourceImpl
import com.binar.projectgroupmakerbinar.data.room.datasource.NotesDataSource
import com.binar.projectgroupmakerbinar.data.room.datasource.NotesDataSourceImpl

object ServiceLocator {

    fun provideUserPreference(context: Context): UserPreference {
        return UserPreference(context)
    }

    fun provideAppDatabase(context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    fun provideNotesDao(context: Context): NotesDao {
        return provideAppDatabase(context).notesDao()
    }

    fun provideCategoryDao(context: Context): CategoriesDao {
        return provideAppDatabase(context).categoriesDao()
    }

    fun provideNotesDataSource(context: Context): NotesDataSource {
        return NotesDataSourceImpl(provideNotesDao(context))
    }

    fun provideCategoryDataSource(context: Context): CategoryDataSource {
        return CategoryDataSourceImpl(provideCategoryDao(context))
    }

    fun provideUserPreferenceDataSource(context: Context): UserPreferenceDataSource {
        return UserPreferenceDataSourceImpl(provideUserPreference(context))
    }

    fun provideLocalRepository(context: Context): LocalRepository {
        return LocalRepositoryImpl(
            provideUserPreferenceDataSource(context),
            provideNotesDataSource(context),
            provideCategoryDataSource(context)
        )
    }


}