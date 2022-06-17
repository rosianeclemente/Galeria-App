package com.example.myapplication.database

import androidx.lifecycle.LiveData
import com.example.myapplication.model.ClosetGram
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ClosetRepositoryDao(private val closetDao: ClosetDao) {
    //    companion object {
//        private lateinit var context: Context
//        fun setContext(contex: Context) {
//            context = contex
//        }
//    }
    fun insert(closet: ClosetGram) = runBlocking {
        launch(Dispatchers.IO) {
            closetDao.insert(closet)
        }
    }

    fun getAll() = closetDao.getAll()

    fun delete(closetId: ClosetGram) {
//        val db = Room
//            .databaseBuilder(context, AppDatabase::class.java, "clos_db")
//            .allowMainThreadQueries()
//            .build()
        return closetDao.remove(closetId)
    }
}
