package com.example.myapplication.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.ClosetAdapter
import com.example.myapplication.database.AppDatabase
import com.example.myapplication.databinding.ActivityRecycleviewBinding
import com.example.myapplication.model.ClosetGram

class ListActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityRecycleviewBinding.inflate(layoutInflater)
    }
    private val closetViewModel by lazy { AppDatabase.getInstace(this).closetDao() }
    private val closetAdapter by lazy {
        ClosetAdapter(onClickListener = { closet ->
            closetDetails(closet)
        })
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.recyclerCloset.adapter = closetAdapter
        clickButtom()
        setUpAdapter()
    }
    fun clickButtom() {
        binding.floating.setOnClickListener {
            val intent = Intent(this, ImageActivity::class.java)
            startActivity(intent)
        }
    }
    fun setUpAdapter() {
        closetViewModel.getAll().observe(this, { closet ->
            closetAdapter.submitList(closet)
        })
    }
    fun closetDetails(closet: ClosetGram) {
        val intent = Intent(this, ClosetDetailsActivity::class.java)
        intent.putExtra("closet", closet)
        startActivity(intent)
    }
}
