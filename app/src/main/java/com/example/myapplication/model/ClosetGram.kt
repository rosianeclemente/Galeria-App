package com.example.myapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class ClosetGram(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val image: ByteArray?,
    val title: String,
) : Serializable
