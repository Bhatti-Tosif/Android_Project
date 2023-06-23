package com.example.android_practice.screens

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_practice.databinding.AddCardDetailCellBinding

class AddCellMainAdapter(val dataList: ArrayList<CellDataModel> ,val addCell: (Int) -> Unit, val deleteCell: (Int) -> Unit, val pickMultipleMedia: ActivityResultLauncher<PickVisualMediaRequest>, val uriList: ArrayList<Uri>): RecyclerView.Adapter<AddCellMainAdapter.AddCellViewHolder>() {

    inner class AddCellViewHolder(val binding: AddCardDetailCellBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindCellData(addCellData: CellDataModel, position: Int) {
            calculateTotal()
            Log.d("Position", position.toString())
            binding.fabAdd.setOnClickListener {
                addCell(position)
            }
            binding.ibCancel.setOnClickListener {
                deleteCell(position)
            }
            binding.btnPickImage.setOnClickListener {
                pickMultipleMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageAndVideo))
            }
            setAdapter()
        }
        private fun calculateTotal() {
            val total = binding.etNo1.text.toString() + binding.etNo2.text.toString()
            binding.tvTotalCount.text = total
        }

        private fun setAdapter() {
            binding.rvImages.layoutManager = LinearLayoutManager(binding.rvImages.context, LinearLayoutManager.HORIZONTAL, false)
            binding.rvImages.adapter = AddCellChildAdapter(uriList)
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

    fun submitList(newList: ArrayList<CellDataModel>) {
        val diffUtil = AddCellCallBack(dataList, newList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        dataList.clear()
        dataList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

}