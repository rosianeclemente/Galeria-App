package com.example.myapplication.ui
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.model.ClosetGram

class ClosetDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    private fun getCloset() {
        val closet: ClosetGram = intent.getSerializableExtra("closet") as ClosetGram
    }
}
