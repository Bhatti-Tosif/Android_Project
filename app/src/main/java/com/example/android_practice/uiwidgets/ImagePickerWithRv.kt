package com.example.android_practice.uiwidgets

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.LinearLayout
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_practice.R
import com.example.android_practice.adapter.ImagePickerAdapter
import com.example.android_practice.databinding.ActivityImagePickerWithRvBinding

class ImagePickerWithRv : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityImagePickerWithRvBinding
    private lateinit var uriList: ArrayList<Uri?>
    private lateinit var adapter: ImagePickerAdapter
    private val pickImage = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImagePickerWithRvBinding.inflate(layoutInflater)
        setContentView(binding.root)
        uriList = arrayListOf()
        binding.btnImagePicker.setOnClickListener(this)
        adapter = ImagePickerAdapter()
        binding.recycler.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recycler.adapter = adapter

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_image_picker -> {
                openImagePicker()
            }
        }
    }

    private val pickMultipleMedia =
        registerForActivityResult(ActivityResultContracts.PickMultipleVisualMedia(5)) { uris ->
            if (uris.isNotEmpty()) {
                uriList.addAll(uris)
                adapter.submitList(uriList)
                adapter.notifyDataSetChanged()
            } else {
                Log.d("PhotoPicker", "No media selected")
            }
        }

    private fun openImagePicker() {
        pickMultipleMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageAndVideo))
    }

}