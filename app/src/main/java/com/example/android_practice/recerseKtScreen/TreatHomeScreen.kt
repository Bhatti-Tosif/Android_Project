package com.example.android_practice.recerseKtScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.content.res.AppCompatResources
import com.example.android_practice.R
import com.example.android_practice.databinding.ActivityTreatHomeScreenBinding
import com.example.android_practice.databinding.DetailCardTodayActivitiesBinding
import com.example.android_practice.databinding.WorkoutDetailCardBinding
import com.example.android_practice.recerseKtScreen.dataModel.Helper
import com.example.android_practice.recerseKtScreen.dataModel.MedicineData
import com.example.android_practice.recerseKtScreen.dataModel.SysData
import com.example.android_practice.recerseKtScreen.dataModel.WorkOutData
import java.time.chrono.HijrahEra

class TreatHomeScreen : AppCompatActivity() {

    private lateinit var binding: ActivityTreatHomeScreenBinding

    private lateinit var medicineCardBinding: ArrayList<DetailCardTodayActivitiesBinding>
    private lateinit var glucoseDetailList: ArrayList<WorkoutDetailCardBinding>

    private var isSelectedLike = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTreatHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getGlucoseDetailBinding()
        setDataToGlucoseDetail()
        sysSetDataSet()
        setCompoundData()
        getMedicineBinding()
        setMedicineData()

        binding.sysCard.ibHeart.setOnClickListener {
            if (isSelectedLike) {
                binding.sysCard.ibHeart.setImageResource(R.drawable.heart)
            } else {
                binding.sysCard.ibHeart.setImageResource(R.drawable.fill_heart)
            }
            isSelectedLike = !isSelectedLike
        }

        binding.diaCard.ibHeart.setOnClickListener {
            if (isSelectedLike) {
                binding.diaCard.ibHeart.setImageResource(R.drawable.heart)
            } else {
                binding.diaCard.ibHeart.setImageResource(R.drawable.fill_heart)
            }
            isSelectedLike = !isSelectedLike
        }

        binding.glucoseCard.root.setOnClickListener {
            val intent = Intent(this, TreatScreen::class.java)
            startActivity(intent)
        }
    }

    private fun getGlucoseDetailBinding() {
        glucoseDetailList = arrayListOf(binding.glucoseCard.cardCalories, binding.glucoseCard.cardRunDuration, binding.glucoseCard.cardSpeed)
    }

    private fun setDataToGlucoseDetail() {
        glucoseDetailList.forEachIndexed { position,it ->
            it.workOutData = Helper.getDataOfGlucoseDetail(this)[position]
        }
    }

    private fun sysSetDataSet() {
        binding.sysCardData = Helper.getSystolicCardData()
        binding.diaCardData = Helper.getDiaCardData()
    }

    private fun getMedicineBinding() {
        medicineCardBinding = arrayListOf(binding.azoptexCard, binding.ketoprofin, binding.otherParacetamol, binding.otherMedicine)
    }

    private fun setMedicineData() {
        medicineCardBinding.forEachIndexed {position, it->
            it.medicineData = Helper.getMedicineData(this)[position]
        }
    }

    private fun setCompoundData() {
        binding.glucoseCardData = Helper.getCompoundsData()
    }
}