package com.example.android_practice.fragment

import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_practice.R
import com.example.android_practice.adapter.SearchRVAdapter
import com.example.android_practice.databinding.FragmentLinearManagerBinding
import com.example.android_practice.databinding.FragmentSearchRecyclerViewBinding
import com.example.android_practice.recycler_view.Constant
import com.example.android_practice.recycler_view.RVContentMargin
import com.example.android_practice.recycler_view.RvAdapter
import com.example.android_practice.recycler_view.RvDataModel

class SearchRecyclerView : Fragment() {

    private lateinit var binding: FragmentSearchRecyclerViewBinding
    private lateinit var rvAdapter: SearchRVAdapter
    private lateinit var newArrayList: ArrayList<RvDataModel>


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentSearchRecyclerViewBinding.inflate(layoutInflater)


        newArrayList = ArrayList<RvDataModel>()
        newArrayList = Constant.getData()
        rvAdapter = SearchRVAdapter(newArrayList)
        binding.rvRestaurant.layoutManager = LinearLayoutManager(container?.context)
        binding.rvRestaurant.adapter = rvAdapter
        setDivider(context)

        binding.searchViewForRv.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }
        })

        return binding.root
    }

    private fun filterList(query: String?) {
        if(query != null) {
            val filteredArrayList = newArrayList.filter {
                it.restaurant.lowercase().contains(query)
            } as ArrayList
            if(filteredArrayList.isEmpty()) {
                Toast.makeText(context, "No Data Found", Toast.LENGTH_SHORT).show()
            } else {
                rvAdapter.setFilteredList(filteredArrayList)
            }
        }
    }

    private fun setDivider(context: Context?) {
        val dividerItemDecoration = DividerItemDecoration(context, RecyclerView.VERTICAL)
        ResourcesCompat.getDrawable(resources ,R.drawable.rv_divider, null)?.let {
            dividerItemDecoration.setDrawable(it)
        }
        binding.rvRestaurant.addItemDecoration(dividerItemDecoration)

        val itemMargin = RVContentMargin()
        binding.rvRestaurant.addItemDecoration(itemMargin)
    }

}