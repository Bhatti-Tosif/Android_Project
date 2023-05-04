package com.example.android_practice.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.updateLayoutParams
import androidx.recyclerview.widget.RecyclerView
import com.example.android_practice.databinding.RvItemViewBinding
import com.example.android_practice.recycler_view.RvDataModel
import com.google.android.material.snackbar.Snackbar

class GridLayoutAdapter(var dataList: ArrayList<RvDataModel>): RecyclerView.Adapter<GridLayoutAdapter.GridViewHolder>() {
    inner class GridViewHolder(var binding: RvItemViewBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val binding = RvItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GridViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {

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

        holder.itemView.setOnClickListener {
            Snackbar.make(it, "Hello", Snackbar.LENGTH_SHORT).show()
        }
    }
}