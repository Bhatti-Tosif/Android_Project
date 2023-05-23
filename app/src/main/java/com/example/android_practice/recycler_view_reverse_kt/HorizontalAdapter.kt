package com.example.android_practice.recycler_view_reverse_kt

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_practice.databinding.HorizontalViewItemBinding

class HorizontalAdapter: RecyclerView.Adapter<HorizontalAdapter.HorizontalViewHolder>() {

    private var postImages: ArrayList<Int> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalViewHolder {

        return HorizontalViewHolder(HorizontalViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return postImages.count()
    }

    override fun onBindViewHolder(holder: HorizontalViewHolder, position: Int) {
        holder.bind(postImages[position])
    }

    inner class HorizontalViewHolder(private val binding: HorizontalViewItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Int) {
            binding.ivPost.setImageResource(item)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(newList: ArrayList<Int>) {
        postImages.addAll(newList)
        notifyDataSetChanged()
    }
}