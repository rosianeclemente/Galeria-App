package com.example.myapplication.ui

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.database.AppDatabase
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.model.ClosetGram
import java.io.ByteArrayOutputStream

class ImageActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val closetViewModel by lazy { AppDatabase.getInstace(this).closetDao() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        ClosetRepositoryDao.setContext(this)
        setContentView(binding.root)
//        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
//           ActivityCompat.requestPermissions(this,  Array<String> {android.Manifest.permission.CAMERA}, 0 )
//        }
        getFoto()
        insert()
    }

    fun getFoto() {
        binding.buttonOpenCamera.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK) {
            val extras: Bundle? = data?.extras
            val image: Bitmap = extras?.get("data") as Bitmap

            val stream = ByteArrayOutputStream()
            image.compress(Bitmap.CompressFormat.PNG, 90, stream)
            val img = stream.toByteArray()

            intent.putExtra("xablue", img)

            binding.imageCamera.setImageBitmap(image)
        }
    }

    fun insert() {
        binding.buttonSalveImage.setOnClickListener {
            val img = intent.getByteArrayExtra("xablue")

            val closet = ClosetGram(
                id = 0,
                image = img,
                title = binding.txtTitle.editableText.toString()
            )
//            closetDao.insert(closet)
            closetViewModel.insert(closet)
            Toast.makeText(this, "Salvo com sucesso", Toast.LENGTH_SHORT).show()
        }
    }
}
