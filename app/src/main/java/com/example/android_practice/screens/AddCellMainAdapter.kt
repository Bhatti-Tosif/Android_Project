package com.example.android_practice.screens

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_practice.databinding.ActivityAddCellPracticeBinding
import com.example.android_practice.databinding.AddCardDetailCellBinding

class AddCellMainAdapter(val dataList: ArrayList<CellDataModel>): RecyclerView.Adapter<AddCellMainAdapter.AddCellViewHolder>() {

    inner class AddCellViewHolder(val binding: AddCardDetailCellBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindCellData(addCellData: CellDataModel, position: Int) {
            calculateTotal()
            binding.fabAdd.setOnClickListener {
                addNewCell(position)
            }
        }
        private fun calculateTotal() {
            val total = binding.etNo1.text.toString() + binding.etNo2.text.toString()
            binding.tvTotalCount.text = total
        }
        private fun addNewCell(position: Int) {
            dataList.add(CellDataModel(0, 0, 0))
            notifyItemInserted(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddCellViewHolder {
        return AddCellViewHolder(AddCardDetailCellBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return dataList.count()
    }

    override fun onBindViewHolder(holder: AddCellViewHolder, position: Int) {
        holder.bindCellData(dataList[position], position)
    }

}