package com.example.android_practice.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.android_practice.R
import com.example.android_practice.adapter.MultiViewAdapter

class MultiViewActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MultiViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_view)

        recyclerView = findViewById(R.id.recycler_view)
        adapter = MultiViewAdapter(getSampleData(), this)
        recyclerView.adapter = adapter
    }

    private fun getSampleData(): List<MyItem> {
        val items = mutableListOf<MyItem>()

        // Add sample items to the list
        items.add(MyItem.SimpleItem("Simple Item 1"))
        items.add(MyItem.HorizontalItem(listOf("Horizontal Item 1", "Horizontal Item 2", "Horizontal Item 3")))
        items.add(MyItem.DropdownItem(listOf("Option 1", "Option 2", "Option 3")))

        return items
    }
}