package com.example.android_practice.screens

import android.annotation.SuppressLint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_practice.R
import com.example.android_practice.databinding.ActivityAddCellPracticeBinding

class AddCellPractice : AppCompatActivity() {

    private lateinit var binding: ActivityAddCellPracticeBinding
    private lateinit var addCellAdapter: AddCellMainAdapter

    private lateinit var cellDataList: ArrayList<CellDataModel>

    private lateinit var uriList: ArrayList<Uri>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddCellPracticeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cellDataList = ArrayList()

        cellDataList.add(CellDataModel(0,0,0,))
        uriList = ArrayList<Uri>()
        addCellAdapter = AddCellMainAdapter(cellDataList, this::addNewCell, this::deleteCell, pickMultipleMedia, uriList)
        binding.rvMainCell.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true)
        binding.rvMainCell.adapter = addCellAdapter
    }

    private fun addNewCell(position: Int) {
        cellDataList.add(CellDataModel(0, 0, 0))
//        addCellAdapter.submitList(cellDataList)
        addCellAdapter.notifyItemInserted(position)
    }

    private fun deleteCell(position: Int) {
        cellDataList.remove(cellDataList[position])
//        addCellAdapter.submitList(cellDataList)
        addCellAdapter.notifyItemRemoved(position)
    }

    @SuppressLint("NotifyDataSetChanged")
    private val pickMultipleMedia =
        registerForActivityResult(ActivityResultContracts.PickMultipleVisualMedia(5)) { uris ->
            if (uris.isNotEmpty()) {
                uriList.addAll(uris)
                addCellAdapter.notifyDataSetChanged()
            } else {
                Log.d("PhotoPicker", "No media selected")
            }
        }

}