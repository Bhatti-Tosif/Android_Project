package com.example.android_practice.recerseKtScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_practice.databinding.ActivityTreatScreenBinding
import com.example.android_practice.databinding.ItemWalkingCardBinding
import com.example.android_practice.recerseKtScreen.adapter.WalkingDetailAdapter
import com.example.android_practice.recerseKtScreen.dataModel.Helper
import com.example.android_practice.recerseKtScreen.dataModel.WalkingData
import com.example.android_practice.recycler_view_reverse_kt.activity.MultiViewMainActivity

class TreatScreen : AppCompatActivity() {
    private lateinit var binding: ActivityTreatScreenBinding
    private lateinit var walkingCardBinding: ArrayList<ItemWalkingCardBinding>
    private lateinit var walkingAdapter: WalkingDetailAdapter
    private lateinit var walkingDataList: ArrayList<WalkingData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTreatScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        compoundsCardDataSet()
        getWalkingCardBinding()

        binding.ibBackArrow.setOnClickListener {
            finish()
        }

        binding.ibWaves.setOnClickListener {
            val intent = Intent(this, MultiViewMainActivity::class.java)
            startActivity(intent)
        }

    }

    private fun compoundsCardDataSet() {

        binding.carbohydrateData = Helper.getCarbohydrateData()
        binding.waterData = Helper.getWaterData()
        binding.cardWater.icMoreVert.visibility = View.GONE
    }

    private fun getWalkingCardBinding() {
        walkingDataList = Helper.getWalkingData(this)
        walkingAdapter = WalkingDetailAdapter()
        binding.rvWalkingData.layoutManager = LinearLayoutManager(this)
        binding.rvWalkingData.adapter = walkingAdapter
        walkingAdapter.submitList(walkingDataList)
    }
}