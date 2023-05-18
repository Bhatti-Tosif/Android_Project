package com.example.android_practice.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android_practice.R
import com.example.android_practice.databinding.ItemLayoutImagePickerRvBinding

class ImagePickerAdapter: androidx.recyclerview.widget.ListAdapter<Uri, ImagePickerAdapter.ImageViewHolder>(ImageDiffUtil()) {

    inner class ImageViewHolder(val binding: ItemLayoutImagePickerRvBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(image: Uri) {
            binding.ivImagePicker.setImageURI(image)
        }
    }

    class ImageDiffUtil: DiffUtil.ItemCallback<Uri>() {
        override fun areItemsTheSame(oldItem: Uri, newItem: Uri): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Uri, newItem: Uri): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(ItemLayoutImagePickerRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}