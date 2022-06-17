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
        @Volatile
        private var INSTACE: AppDatabase? = null

        fun getInstace(context: Context): AppDatabase {
            return INSTACE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "closet_d"
                ).allowMainThreadQueries().build()
                INSTACE = instance
                instance
            }
        }
    }
}
