package com.example.android_practice.recerseKtScreen
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import com.example.android_practice.R
import com.example.android_practice.databinding.ActivityTreatScreenBinding
import com.example.android_practice.databinding.WalkingCardBinding
import com.example.android_practice.databinding.WorkoutDetailCardBinding
import com.example.android_practice.recerseKtScreen.dataModel.CarbohydratesData
import com.example.android_practice.recerseKtScreen.dataModel.Helper
import com.example.android_practice.recerseKtScreen.dataModel.WalkingData
import com.example.android_practice.recerseKtScreen.dataModel.WorkOutData

class TreatScreen : AppCompatActivity() {
    private lateinit var binding: ActivityTreatScreenBinding
    private lateinit var walkingCardBinding: ArrayList<WalkingCardBinding>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTreatScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        compoundsCardDataSet()
        getWalkingCardBinding()
        walkingCardDatSet()
        caloriesDataSet()

        binding.ibBackArrow.setOnClickListener {
            finish()
        }

    }
    private fun compoundsCardDataSet() {

        binding.carbohydrateData = Helper.getCarbohydrateData()
        binding.waterData = Helper.getWaterData()
        binding.cardWater.icMoreVert.visibility = View.GONE
    }

    private fun getWalkingCardBinding() {
        walkingCardBinding = arrayListOf(binding.cardWalking, binding.cardFitness, binding.cardGym)
    }
    private fun walkingCardDatSet() {
        walkingCardBinding.forEachIndexed { index, walkingCardBinding ->
            walkingCardBinding.walkingData = Helper.getWalkingData(this)[index]
        }
    }
    private fun caloriesDataSet() {

        walkingCardBinding.forEachIndexed {position, it ->
            it.walkDetailCard.cardCalories.workOutData = Helper.getWorkOutData(this)[0]
            it.walkDetailCard.cardRunDuration.workOutData = Helper.getWorkOutData(this)[1]
            it.walkDetailCard.cardSpeed.workOutData =Helper.getWorkOutData(this)[2]
        }

    }
}