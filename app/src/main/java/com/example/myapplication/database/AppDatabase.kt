package com.example.myapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.model.ClosetGram

@Database(entities = [ClosetGram::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun closetDao(): ClosetDao
    companion object {

        @Volatile private var db: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            return db ?: Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "orgs.db"
            ).build()
                .also {
                    db = it
                }
        }
    }
}
