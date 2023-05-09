package com.example.android_practice.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_practice.databinding.PastReservationItemBinding
import com.example.android_practice.screens.tagB.RentalViewHolder
import com.example.android_practice.screens.tagB.dataModel.RentalModel

class RentalAdapter(var rentalData: ArrayList<RentalModel>): RecyclerView.Adapter<RentalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RentalViewHolder {
        return RentalViewHolder(PastReservationItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return rentalData.count()
    }

    override fun onBindViewHolder(holder: RentalViewHolder, position: Int) {

        holder.bind(rentalData[position], position)

    }

    fun changeData(list: ArrayList<RentalModel>) {
        rentalData.clear()
        rentalData.addAll(list)
        notifyDataSetChanged()
    }
}