package com.example.android_practice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.updateLayoutParams
import androidx.recyclerview.widget.RecyclerView
import com.example.android_practice.R
import com.example.android_practice.databinding.RvItemViewBinding
import com.example.android_practice.recycler_view.RvDataModel

class StaggeredAdapter(var dataList: ArrayList<RvDataModel>): RecyclerView.Adapter<StaggeredAdapter.StaggeredViewHolder>() {
    inner class StaggeredViewHolder(var binding: RvItemViewBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StaggeredViewHolder {
        val binding = RvItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StaggeredViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StaggeredViewHolder, position: Int) {
        holder.binding.ivItem.setImageResource(dataList[position].image)
        holder.binding.tvRestaurantName.text = dataList[position].restaurant

        holder.binding.ivItem.updateLayoutParams<ConstraintLayout.LayoutParams> {
            bottomToBottom = ConstraintLayout.LayoutParams.UNSET
            endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
            width = 0
            height = 250
        }
        holder.binding.tvRestaurantName.updateLayoutParams<ConstraintLayout.LayoutParams> {
            startToEnd = ConstraintLayout.LayoutParams.UNSET
            topToTop = ConstraintLayout.LayoutParams.UNSET

            startToStart = holder.binding.ivItem.id
            topToBottom = holder.binding.ivItem.id
            endToEnd = holder.binding.ivItem.id
        }
        holder.binding.tvRestaurantAddress.visibility = View.GONE
    }

    override fun getItemCount(): Int {
        return dataList.count()
    }
}