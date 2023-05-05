package com.example.android_practice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.android_practice.databinding.RvItemViewBinding
import com.example.android_practice.recycler_view.RvDataModel

class SearchRVAdapter(var dataList: ArrayList<RvDataModel>): RecyclerView.Adapter<SearchRVAdapter.SearchViewHolder>() {

    inner class SearchViewHolder(var binding: RvItemViewBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        var binding = RvItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SearchViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.count()
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.binding.ivItem.setImageResource(dataList[position].image)
        holder.binding.tvRestaurantName.text = dataList[position].restaurant
        holder.binding.tvRestaurantAddress.text = dataList[position].address

        animationForItem(holder.itemView)
    }

    fun setFilteredList(datList: ArrayList<RvDataModel>) {
        this.dataList = datList
        notifyDataSetChanged()
    }


    private fun animationForItem(view: View) {
        val animation = AlphaAnimation(0.0f, 1.0f)
        animation.duration = 1500
        view.startAnimation(animation)
    }
}