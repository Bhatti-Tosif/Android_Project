package com.example.android_practice.recycler_view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android_practice.R
import com.example.android_practice.databinding.RvItemViewBinding
import com.google.android.material.snackbar.Snackbar

class RvAdapter(private var dataList: ArrayList<RvDataModel> = ArrayList<RvDataModel>()): RecyclerView.Adapter<RvAdapter.RvViewHolder>() {

    inner class RvViewHolder(var binding: RvItemViewBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
//        val view = LayoutInflater.from(context).inflate(R.layout.rv_item_view, parent, false)
//        return RvViewHolder(view)
        val binding = RvItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RvViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        holder.binding.ivItem.setImageResource(dataList[position].image)
        holder.binding.tvRestaurantName.text = dataList[position].restaurant
        holder.binding.tvRestaurantAddress.text = dataList[position].address

        animationForItem(holder.itemView)
        holder.itemView.setOnClickListener {
            Snackbar.make(it, "Item Is Selected", Snackbar.LENGTH_SHORT).show()
        }
    }

    fun  setData(newList: ArrayList<RvDataModel>) {
        val diffUtil = LinearDiffUtilCallBack(dataList, newList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        dataList.clear()
        dataList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    private fun animationForItem(view: View) {
        val animation = AlphaAnimation(0.0f, 1.0f)
        animation.duration = 1500
        view.startAnimation(animation)
    }
}