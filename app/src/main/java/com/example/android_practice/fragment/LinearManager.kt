package com.example.android_practice.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_practice.R
import com.example.android_practice.databinding.FragmentChatBinding
import com.example.android_practice.databinding.FragmentLinearManagerBinding
import com.example.android_practice.recycler_view.Constant
import com.example.android_practice.recycler_view.RVContentMargin
import com.example.android_practice.recycler_view.RvAdapter
import com.example.android_practice.recycler_view.RvDataModel
import java.util.Locale

class LinearManager : Fragment() {

    private lateinit var binding: FragmentLinearManagerBinding

    private lateinit var rvAdapter: RvAdapter

    private lateinit var filterArrayList: ArrayList<RvDataModel>
    private lateinit var newArrayList: ArrayList<RvDataModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLinearManagerBinding.inflate(layoutInflater)

        newArrayList = Constant.getData()
        filterArrayList = Constant.getData()

        rvAdapter = RvAdapter(filterArrayList)
        binding.rvRestaurant.layoutManager = LinearLayoutManager(container?.context)
        binding.rvRestaurant.adapter = rvAdapter


        setDivider(context)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.search_view_item, menu)
        val item = menu.findItem(R.id.search_action)
        val searchView = item.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterArrayList.clear()
                val searchText = newText?.let {
                    newText.lowercase(Locale.getDefault())
                }
                if (searchText!!.isNotEmpty()) {

                    newArrayList.forEach {
                        if(it.restaurant.lowercase().contains(searchText)) {
                            filterArrayList.add(it)
                        }
                    }
                    binding.rvRestaurant.adapter?.notifyDataSetChanged()
                }
                else {
                    filterArrayList.clear()
                    filterArrayList.addAll(newArrayList)
                    binding.rvRestaurant.adapter?.notifyDataSetChanged()
                }
                return false
            }

        })

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