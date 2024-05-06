package com.example.examplecamerax

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.examplecamerax.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOpenCamera.setOnClickListener(){
            cameraProviderResult.launch(android.Manifest.permission.CAMERA)
        }
    }

    private val cameraProviderResult =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            if (it)
                abrirTelaDePreview()
            else
                Snackebar.make(bindin.root, "Acesso negado")
        }

    private fun abrirTelaDePreview(){
        val intentCameraPreview = intent(this, CameraPreviewActivity::class.java)
        startActivity(intentCameraPreview)
    }
}