package com.example.android_practice.recycler_view_reverse_kt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_practice.databinding.ActivityMultiViewMainBinding

class MultiViewMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMultiViewMainBinding

    private lateinit var adapter: MultiViewMainAdapter
    private lateinit var itemList: ArrayList<MultiViewType>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMultiViewMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        itemList = Helper.getData()
        adapter = MultiViewMainAdapter()
        binding.rvMain.layoutManager = LinearLayoutManager(this)
        binding.rvMain.adapter = adapter

        adapter.submitList(itemList)
    }
}