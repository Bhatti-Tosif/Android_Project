package com.example.android_practice.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android_practice.databinding.PastReservationItemBinding
import com.example.android_practice.recycler_view.RvDataModel
import com.example.android_practice.screens.tagB.RentalViewHolder
import com.example.android_practice.screens.tagB.dataModel.RentalModel

class RentalAdapter(private val changeDetail: (Int) -> Unit): ListAdapter<RentalModel, RentalViewHolder>(RentalDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RentalViewHolder {
        return RentalViewHolder(PastReservationItemBinding.inflate(LayoutInflater.from(parent.context), parent, false), changeDetail)
    }
    override fun onBindViewHolder(holder: RentalViewHolder, position: Int) {

        //holder.bind(rentalData[position], position)
        holder.bind(getItem(position), position)

    }

    class RentalDiffCallBack: DiffUtil.ItemCallback<RentalModel>() {
        override fun areItemsTheSame(oldItem: RentalModel, newItem: RentalModel): Boolean {
            return oldItem.rentalID == newItem.rentalID
        }
        override fun areContentsTheSame(oldItem: RentalModel, newItem: RentalModel): Boolean {
            return oldItem == newItem
        }

    }
}
