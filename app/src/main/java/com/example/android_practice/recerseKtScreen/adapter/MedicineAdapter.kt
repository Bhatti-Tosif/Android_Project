package com.example.android_practice.recerseKtScreen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android_practice.databinding.DetailCardTodayActivitiesBinding
import com.example.android_practice.recerseKtScreen.dataModel.MedicineData

class MedicineAdapter: RecyclerView.Adapter<MedicineAdapter.MedicineViewHolder>() {

    private val medicineDataList = ArrayList<MedicineData>()

    inner class MedicineViewHolder(val binding: DetailCardTodayActivitiesBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindMedicineData(medicineData: MedicineData) {
            binding.medicineData = medicineData
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicineViewHolder {
        return MedicineViewHolder(DetailCardTodayActivitiesBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return medicineDataList.size
    }

    override fun onBindViewHolder(holder: MedicineViewHolder, position: Int) {
        holder.bindMedicineData(medicineDataList[position])
    }

    fun submitList(newList: ArrayList<MedicineData>) {
        val diffUtil = MedicineUtilCallBack(medicineDataList, newList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        medicineDataList.clear()
        medicineDataList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }
}