package com.example.android_practice.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_practice.adapter.SwappableAdapter
import com.example.android_practice.databinding.FragmentSwipableRvBinding
import com.example.android_practice.recycler_view.Constant
import com.example.android_practice.recycler_view.RvDataModel
import com.google.android.material.snackbar.Snackbar


class SwappableRv : Fragment() {

    private lateinit var binding: FragmentSwipableRvBinding
    private lateinit var rvAdapter: SwappableAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSwipableRvBinding.inflate(inflater)

        val datList = Constant.getData()
        rvAdapter = SwappableAdapter(datList)
        binding.rvRestaurant.layoutManager = LinearLayoutManager(container?.context)
        binding.rvRestaurant.adapter = rvAdapter
        swappable(datList)

        return binding.root
    }

    fun swappable(data: ArrayList<RvDataModel>) {
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val deletedItem: RvDataModel = data[position]

                data.removeAt(position)
                rvAdapter.notifyItemRemoved(position)

                Snackbar.make(binding.rvRestaurant, "Deleted: " + deletedItem.restaurant, Snackbar.LENGTH_LONG)
                    .setAction("Undo"
                    ) {
                        data.add(position, deletedItem)
                        rvAdapter.notifyItemInserted(position)
                    }.show()
            }

        }).attachToRecyclerView(binding.rvRestaurant)
    }

}