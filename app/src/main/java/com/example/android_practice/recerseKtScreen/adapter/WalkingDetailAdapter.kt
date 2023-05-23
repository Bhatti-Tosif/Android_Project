package com.example.android_practice.recerseKtScreen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android_practice.databinding.ItemWalkingCardBinding
import com.example.android_practice.recerseKtScreen.dataModel.Helper
import com.example.android_practice.recerseKtScreen.dataModel.WalkingData
import com.example.android_practice.recerseKtScreen.dataModel.WorkOutData

class WalkingDetailAdapter: RecyclerView.Adapter<WalkingDetailAdapter.WalkingViewHolder>() {

    private val walkingDataList = ArrayList<WalkingData>()
    private lateinit var workOutData: ArrayList<WorkOutData>

    inner class WalkingViewHolder(val binding: ItemWalkingCardBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: WalkingData) {
            binding.walkingData = item
            binding.executePendingBindings()
            workOutData = Helper.getWorkOutData(binding.root.context)
            binding.walkDetailCard.cardCalories.workOutData = workOutData[0]
            binding.walkDetailCard.cardRunDuration.workOutData = workOutData[1]
            binding.walkDetailCard.cardSpeed.workOutData = workOutData[2]
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WalkingViewHolder {
        return WalkingViewHolder(ItemWalkingCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return walkingDataList.count()
    }

    override fun onBindViewHolder(holder: WalkingViewHolder, position: Int) {
        holder.bind(walkingDataList[position])
    }

    fun submitList(newList: ArrayList<WalkingData>) {
        val diffUtil = WalkingDetailCallBack(walkingDataList, newList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        walkingDataList.clear()
        walkingDataList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }
}