package com.example.myapplication.database

import androidx.lifecycle.LiveData
import androidx.room.* // ktlint-disable no-wildcard-imports
import com.example.myapplication.model.ClosetGram

@Dao
interface ClosetDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg closet: ClosetGram)

    @Query("SELECT * FROM closetgram")
    fun getAll(): LiveData<List<ClosetGram>>

    @Delete
    fun remove(closetId: ClosetGram)
}
