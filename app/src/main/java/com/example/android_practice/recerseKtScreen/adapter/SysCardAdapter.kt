package com.example.android_practice.recerseKtScreen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android_practice.R
import com.example.android_practice.databinding.ItemSysCardBinding
import com.example.android_practice.recerseKtScreen.dataModel.Helper
import com.example.android_practice.recerseKtScreen.dataModel.SysData

class SysCardAdapter(private val onLikedInterFace: ClickHandle) :
    RecyclerView.Adapter<SysCardAdapter.SysViewHolder>() {

    val dataList = ArrayList<SysData>()

    inner class SysViewHolder(val binding: ItemSysCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindSysCardData(sysData: SysData, position: Int) {
            binding.sysData = sysData
            binding.executePendingBindings()
            binding.ibHeart.setOnClickListener {
                onLikedInterFace.onLikedClickInterface(position)
            }
            likeBtnDrawableToggle(sysData)
        }

        fun likeBtnDrawableToggle(sysData: SysData) {
            if (sysData.isLiked) {
                binding.ibHeart.setImageResource(R.drawable.fill_heart)
            } else {
                binding.ibHeart.setImageResource(R.drawable.heart)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SysViewHolder {
        return SysViewHolder(
            ItemSysCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return dataList.count()
    }

    override fun onBindViewHolder(holder: SysViewHolder, position: Int) {
        holder.bindSysCardData(dataList[position], position)
    }

    override fun onBindViewHolder(
        holder: SysViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isEmpty()) {
            onBindViewHolder(holder, position)
        } else {
            when (payloads[0]) {
                Helper.PayloadConstants.LikedButtonChanged -> {
                    holder.likeBtnDrawableToggle(dataList[position])
                }
            }
        }
    }

    fun submitList(newList: ArrayList<SysData>) {
        val diffUtil = SysUtilCallBack(dataList, newList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        dataList.clear()
        dataList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

}