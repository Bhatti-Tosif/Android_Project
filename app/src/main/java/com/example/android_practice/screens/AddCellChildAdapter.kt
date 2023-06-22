package com.example.android_practice.screens

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_practice.databinding.PickedImageDetailBinding

class AddCellChildAdapter(var uriList: ArrayList<Uri>): RecyclerView.Adapter<AddCellChildAdapter.ChildViewHolder>() {

    inner class ChildViewHolder(val binding: PickedImageDetailBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(uriData: Uri) {
            binding.ivPickImage.setImageURI(uriData)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        return ChildViewHolder(PickedImageDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return uriList.count()
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        holder.bind(uriList[position])
    }
}