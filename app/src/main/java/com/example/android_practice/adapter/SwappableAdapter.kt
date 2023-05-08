package com.example.android_practice.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_practice.R
import com.example.android_practice.databinding.FragmentExpandableRvBinding
import com.example.android_practice.databinding.FragmentSwipableRvBinding
import com.example.android_practice.databinding.RvItemViewBinding
import com.example.android_practice.recycler_view.RvDataModel

class SwappableAdapter(val dataList: ArrayList<RvDataModel>): RecyclerView.Adapter<SwappableAdapter.SwappableHolder>() {

    class SwappableHolder(val binding: RvItemViewBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(data: RvDataModel) {
            binding.ivItem.setImageResource(data.image)
            binding.tvRestaurantName.text = data.restaurant
            binding.tvRestaurantAddress.text = data.address
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SwappableHolder {
        val binding = RvItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return SwappableHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.count()
    }

    override fun onBindViewHolder(holder: SwappableHolder, position: Int) {
        holder.bind(dataList[position])
    }
}