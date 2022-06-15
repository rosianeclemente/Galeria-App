package com.example.myapplication

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
//        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
//           ActivityCompat.requestPermissions(this,  Array<String> {android.Manifest.permission.CAMERA}, 0 )
//        }
        getFoto()
    }

    fun getFoto() {
        binding.buttonOpenCamera.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            val extras: Bundle? = data?.getExtras()
            val imagem: Bitmap = extras?.get("data") as Bitmap
            binding.imageCamera.setImageBitmap(imagem)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}
