package com.example.android_practice.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_practice.R
import com.example.android_practice.databinding.FragmentLinearManagerBinding
import com.example.android_practice.recycler_view.Constant
import com.example.android_practice.recycler_view.RVContentMargin
import com.example.android_practice.recycler_view.RvAdapter
import com.example.android_practice.recycler_view.RvDataModel

class LinearManager : Fragment() {

    private lateinit var binding: FragmentLinearManagerBinding

    private lateinit var rvAdapter: RvAdapter

    private lateinit var newArrayList: ArrayList<RvDataModel>
    private lateinit var changedList: ArrayList<RvDataModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLinearManagerBinding.inflate(layoutInflater)

        newArrayList = Constant.getData()

        rvAdapter = RvAdapter()
        binding.rvRestaurant.layoutManager = LinearLayoutManager(container?.context)
        rvAdapter.setData(newArrayList)
        binding.rvRestaurant.adapter = rvAdapter

        binding.btnAdd.setOnClickListener {
            val newName = binding.etForAdd.text.toString()
            newArrayList.add(RvDataModel(R.drawable.hotel1, newName, "Ahmedabad"))
            rvAdapter.setData(newArrayList)
        }
        binding.btnClear.setOnClickListener {
            newArrayList.clear()
            rvAdapter.setData(newArrayList)
        }
        setDivider(context)
        return binding.root
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