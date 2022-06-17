package com.example.myapplication.model

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.ByteArrayOutputStream
import java.io.Serializable

@Entity
class ClosetGram(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val image: ByteArray?,
    val title: String,
) : Serializable{
    fun getImage(){

    }
}
