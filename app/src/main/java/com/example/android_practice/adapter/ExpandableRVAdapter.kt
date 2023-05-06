package com.example.android_practice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_practice.R
import com.example.android_practice.databinding.ExpandableRecyclerItemBinding
import com.example.android_practice.recycler_view.ExpandDataModel

class ExpandableRVAdapter(private var dataList: ArrayList<ExpandDataModel>): RecyclerView.Adapter<ExpandableRVAdapter.ExpandableViewHolder>() {

    inner class ExpandableViewHolder(var binding: ExpandableRecyclerItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpandableViewHolder {
        val binding = ExpandableRecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExpandableViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.count()
    }

    override fun onBindViewHolder(holder: ExpandableViewHolder, position: Int) {
        holder.binding.ivItem.setImageResource(dataList[position].image)
        holder.binding.tvRestaurantName.text = dataList[position].restaurant
        holder.binding.tvRestaurantAddress.text = dataList[position].address
        holder.binding.tvDescription.text = dataList[position].description

        holder.binding.tvDescription.visibility = if(dataList[position].isExpand) View.VISIBLE else View.GONE

        holder.itemView.setOnClickListener {
            dataList[position].isExpand = !dataList[position].isExpand
            notifyItemChanged(position)
        }

    }
}