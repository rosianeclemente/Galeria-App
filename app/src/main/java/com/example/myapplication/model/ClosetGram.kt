package com.example.myapplication.model

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class ClosetGram(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val image: Bitmap?,
    val title: String,
)
