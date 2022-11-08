package com.binar.projectgroupmakerbinar.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.binar.projectgroupmakerbinar.data.room.dao.MemberDao
import com.binar.projectgroupmakerbinar.data.room.entity.MemberEntity


import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


@Database(entities = [MemberEntity::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun memberDao(): MemberDao

    companion object {
        private const val DB_NAME = "RANDOMAPP.db"

        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
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
                // return instance
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
            AppDatabase.getInstance(context).memberDao().insertMembers(prepopulateNotes())
        }
    }


    private fun prepopulateNotes(): List<MemberEntity> {
        return mutableListOf(
            MemberEntity( name = "SATU A", note="Catatan Group A", group = "Group A"),
            MemberEntity( name = "DUA A", note="Catatan Group A", group = "Group A"),
            MemberEntity( name = "TIGA A", note="Catatan Group A", group = "Group A"),
            MemberEntity( name = "EMPAT A", note="Catatan Group A", group = "Group A"),
            MemberEntity( name = "LIMA A", note="Catatan Group A", group = "Group A"),

            MemberEntity( name = "SATU B", note="Catatan Group B", group = "Group B"),
            MemberEntity( name = "DUA B", note="Catatan Group B", group = "Group B"),
            MemberEntity( name = "TIGA B", note="Catatan Group B", group = "Group B"),
            MemberEntity( name = "EMPAT B", note="Catatan Group B", group = "Group B"),
            MemberEntity( name = "LIMA B", note="Catatan Group B", group = "Group B"),

            MemberEntity( name = "SATU C", note="Catatan Group C", group = "Group C"),
            MemberEntity( name = "DUA C", note="Catatan Group C", group = "Group C"),
            MemberEntity( name = "TIGA C", note="Catatan Group C", group = "Group C"),
            MemberEntity( name = "EMPAT C", note="Catatan Group C", group = "Group C"),
            MemberEntity( name = "LIMA C", note="Catatan Group C", group = "Group C"),
        )
    }
}