package com.example.myapplication

import android.app.Application
import com.example.myapplication.database.AppDatabase
import com.example.myapplication.database.ClosetRepositoryDao

class App : Application() {
    //    @TypeConverter
//    fun toByteArray(bitmap: Bitmap): ByteArray {
//        val stream = ByteArrayOutputStream()
//        bitmap?.compress(Bitmap.CompressFormat.PNG,0,stream)
//        return stream.toByteArray()
//    }
//    @TypeConverter
//    fun toBitmap(byteArray: ByteArray): Bitmap? {
//        return BitmapFactory.decodeByteArray(byteArray,0,byteArray.size)
//    }
    val database by lazy { AppDatabase.getInstace(this) }
    val repository by lazy { ClosetRepositoryDao(database.closetDao()) }
}
