package com.binar.projectgroupmakerbinar.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.binar.projectgroupmakerbinar.constant.CommonConstant
import com.binar.projectgroupmakerbinar.data.room.dao.GroupDao
import com.binar.projectgroupmakerbinar.data.room.dao.MemberDao
import com.binar.projectgroupmakerbinar.data.room.dao.ResultDao
import com.binar.projectgroupmakerbinar.data.room.entity.Group
import com.binar.projectgroupmakerbinar.data.room.entity.Member
import com.binar.projectgroupmakerbinar.data.room.entity.ResultData


import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


@Database(entities = [Member::class, Group::class, ResultData::class], version = 4, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun memberDao(): MemberDao
    abstract fun groupDao(): GroupDao
    abstract fun resultDao(): ResultDao


    companion object {
        private const val DB_NAME = CommonConstant.DATABASE_NAME

        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DB_NAME
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(DatabaseSeederCallback(context))
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

}


class DatabaseSeederCallback(private val context: Context) : RoomDatabase.Callback() {
    private val job = Job()
    private val scope = CoroutineScope(Dispatchers.IO + job)

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        scope.launch {

        }
    }




}