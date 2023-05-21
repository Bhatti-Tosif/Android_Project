package com.example.android_practice.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_practice.R
import com.example.android_practice.databinding.ActivityAddCellPracticeBinding

class AddCellPractice : AppCompatActivity() {

    private lateinit var binding: ActivityAddCellPracticeBinding
    private lateinit var addCellAdapter: AddCellMainAdapter

    private lateinit var cellDataList: ArrayList<CellDataModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddCellPracticeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cellDataList = ArrayList()
        cellDataList.add(CellDataModel(0,0,0,))
        addCellAdapter = AddCellMainAdapter(cellDataList)
        binding.rvMainCell.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true)
        binding.rvMainCell.adapter = addCellAdapter
    }
}