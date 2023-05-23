package com.example.android_practice.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.android_practice.R
import com.example.android_practice.screens.MyItem

class MultiViewAdapter(private val items: List<MyItem>, private val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            MyItem.SimpleItem.VIEW_TYPE -> {
                val simpleView = inflater.inflate(R.layout.simple_view_item, parent, false)
                SimpleViewHolder(simpleView)
            }
            MyItem.HorizontalItem.VIEW_TYPE -> {
                val horizontalView = inflater.inflate(R.layout.rv_item_view, parent, false)
                HorizontalViewHolder(horizontalView)
            }
            MyItem.DropdownItem.VIEW_TYPE -> {
                val dropdownView = inflater.inflate(R.layout.item_dropdown, parent, false)
                DropdownViewHolder(dropdownView)
            }
            else -> throw IllegalArgumentException("Invalid view type: $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        when (holder) {
            is SimpleViewHolder -> holder.bind(item as MyItem.SimpleItem)
            is HorizontalViewHolder -> holder.bind(item as MyItem.HorizontalItem)
            is DropdownViewHolder -> holder.bind(item as MyItem.DropdownItem)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].viewType
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class SimpleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(R.id.text_view)
        private val imageView: ImageView = itemView.findViewById(R.id.image_view)

        fun bind(item: MyItem.SimpleItem) {
            // Bind data to views

            // ...
        }
    }

    inner class HorizontalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val horizontalRecyclerView: RecyclerView = itemView.findViewById(R.id.horizontal_recycler_view)

        init {
            val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            val snapHelper = LinearSnapHelper()
            snapHelper.attachToRecyclerView(horizontalRecyclerView)
            horizontalRecyclerView.layoutManager = layoutManager
        }

        fun bind(item: MyItem.HorizontalItem) {
            // Bind data and set up horizontal RecyclerView adapter

            // ...
        }
    }

    inner class DropdownViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val dropdownMenu: Spinner = itemView.findViewById(R.id.dropdown_menu)

        fun bind(item: MyItem.DropdownItem) {
            // Bind data and set up dropdown menu adapter

            // ...
        }
    }
}
