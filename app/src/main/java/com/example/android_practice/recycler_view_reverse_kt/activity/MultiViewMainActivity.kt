package com.example.android_practice.recycler_view_reverse_kt.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_practice.databinding.ActivityMultiViewMainBinding
import com.example.android_practice.recycler_view_reverse_kt.adapter.MultiViewMainAdapter
import com.example.android_practice.recycler_view_reverse_kt.data_modal.Helper
import com.example.android_practice.recycler_view_reverse_kt.data_modal.MultiViewType

class MultiViewMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMultiViewMainBinding

    private lateinit var adapter: MultiViewMainAdapter
    private lateinit var itemList: ArrayList<MultiViewType>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMultiViewMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        itemList = Helper.getData(this)
        adapter = MultiViewMainAdapter(this::onClickPost, this::onSimpleViewClick)
        binding.rvMain.layoutManager = LinearLayoutManager(this)
        binding.rvMain.adapter = adapter

        adapter.submitList(itemList)
    }

    private fun onClickPost(position: Int) {
        Toast.makeText(this, "Horizontal Position: $position", Toast.LENGTH_SHORT).show()
    }

    private fun onSimpleViewClick(item: MultiViewType.SimpleItem) {
        Toast.makeText(this, "User: ${item.userName}", Toast.LENGTH_SHORT).show()
    }
}