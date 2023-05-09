package com.example.android_practice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_practice.databinding.HeaderItemViewBinding
import com.example.android_practice.databinding.SimpleViewItemBinding
import com.example.android_practice.recycler_view.HotelData

class MultipleHolderAdapter(val dataList: ArrayList<HotelData>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val NORMAL_VIEW = 0
        const val HEADER_VIEW = 1
    }

    private class HeaderViewHolder(private val binding: HeaderItemViewBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: HotelData) {
            binding.header = data
            binding.executePendingBindings()
        }

    }
    private class SimpleViewHolder(private val binding: SimpleViewItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: HotelData){
            binding.hotel = data
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == NORMAL_VIEW) {
            return SimpleViewHolder(SimpleViewItemBinding.inflate(LayoutInflater.from(parent.context)))
        }
        return HeaderViewHolder(HeaderItemViewBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return dataList.count()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? SimpleViewHolder).let {
            it?.bind(dataList[position])
        }
        (holder as? HeaderViewHolder).let {
            it?.bind(dataList[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return dataList[position].typeOfView
    }
}