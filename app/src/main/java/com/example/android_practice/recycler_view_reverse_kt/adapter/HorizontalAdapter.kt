package com.example.android_practice.recycler_view_reverse_kt.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_practice.databinding.ItemYoutubePostHorizontalBinding

class HorizontalAdapter(val onPostClick: (Int) -> Unit) :
    RecyclerView.Adapter<HorizontalAdapter.HorizontalViewHolder>() {

    private var postImages: ArrayList<Int> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalViewHolder =
        HorizontalViewHolder(
            ItemYoutubePostHorizontalBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int {
        return postImages.count()
    }

    override fun onBindViewHolder(holder: HorizontalViewHolder, position: Int) =
        holder.bind(postImages[position], position)


    inner class HorizontalViewHolder(private val binding: ItemYoutubePostHorizontalBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Int, position: Int) {
            binding.ivPost.setImageResource(item)
            binding.ivPost.setOnClickListener {
                onPostClick(position)
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(newList: ArrayList<Int>) {
        postImages.addAll(newList)
        notifyDataSetChanged()
    }
}