package com.example.android_practice.recycler_view_reverse_kt.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_practice.databinding.ActivityMultiViewMainBinding
import com.example.android_practice.databinding.ItemDropDownViewTypeBinding
import com.example.android_practice.recycler_view_reverse_kt.adapter.MultiViewMainAdapter
import com.example.android_practice.recycler_view_reverse_kt.data_modal.Helper
import com.example.android_practice.recycler_view_reverse_kt.data_modal.MultiViewType
import com.google.android.material.snackbar.Snackbar

class MultiViewMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMultiViewMainBinding

    private lateinit var dropDownBinding: ItemDropDownViewTypeBinding

    private lateinit var adapter: MultiViewMainAdapter
    private lateinit var itemList: ArrayList<MultiViewType>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMultiViewMainBinding.inflate(layoutInflater)

        dropDownBinding = ItemDropDownViewTypeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        itemList = Helper.getData(this)
        adapter =
            MultiViewMainAdapter(this::onClickPost, this::onSimpleViewClick, this::onDropDownClick)
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

    private fun onDropDownClick(
        binding: ItemDropDownViewTypeBinding, item: MultiViewType.DropdownItem
    ) {
        if (item.isExpand) {
            binding.tvReadComment.visibility = View.VISIBLE
            binding.rvListOfComment.visibility = View.GONE
            Snackbar.make(this, binding.root, "Collapsed", Snackbar.LENGTH_SHORT).show()
        } else {
            binding.tvReadComment.visibility = View.GONE
            binding.rvListOfComment.visibility = View.VISIBLE
            Snackbar.make(this, binding.root, "Expanded", Snackbar.LENGTH_SHORT).show()
        }
        item.isExpand = !item.isExpand
    }
}