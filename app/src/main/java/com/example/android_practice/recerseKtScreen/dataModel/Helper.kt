package com.example.android_practice.recerseKtScreen.dataModel

import android.content.Context
import androidx.appcompat.content.res.AppCompatResources
import com.example.android_practice.R

object Helper {
    private lateinit var carbohydrateData: CarbohydratesData
    private lateinit var waterData: CarbohydratesData
    private lateinit var walkingDataList: ArrayList<WalkingData>
    private lateinit var workoutDataList: ArrayList<WorkOutData>
    private lateinit var glucoseDetailList: ArrayList<WorkOutData>
    private lateinit var systolicDataList: SysData
    private lateinit var diaData: SysData
    private lateinit var medicineDataList: ArrayList<MedicineData>
    private lateinit var compoundsDetail: GlucoseCardData

    fun getCarbohydrateData(): CarbohydratesData {
        carbohydrateData = CarbohydratesData("Carbohydrates", "10", "%", R.drawable.ic_girl)
        return carbohydrateData
    }

    fun getWaterData(): CarbohydratesData {
        waterData = CarbohydratesData("Water", "2 Liters", "/day", R.drawable.ic_girl)
        return waterData
    }

    fun getWalkingData(context: Context): ArrayList<WalkingData> {
        walkingDataList = ArrayList<WalkingData>()
        walkingDataList.add(
            WalkingData(
                "Walking",
                "12:00",
                "12",
                context.getString(R.string.desc_medical_text),
                AppCompatResources.getDrawable(context, R.drawable.walk_person)
            )
        )
        walkingDataList.add(
            WalkingData(
                "Fitness",
                "01:00",
                "15",
                context.getString(R.string.desc_medical_text),
                AppCompatResources.getDrawable(context, R.drawable.fitness_center)
            )
        )
        walkingDataList.add(
            WalkingData(
                "Running",
                "09:00",
                "15",
                context.getString(R.string.desc_medical_text),
                AppCompatResources.getDrawable(context, R.drawable.walk_person)
            )
        )
        return walkingDataList
    }

    fun getWorkOutData(context: Context): ArrayList<WorkOutData> {
        workoutDataList = ArrayList<WorkOutData>()
        workoutDataList.add(
            WorkOutData(
                "Calories",
                "8.5 mmol/L",
                AppCompatResources.getDrawable(context, R.drawable.charge_ic)
            )
        )
        workoutDataList.add(
            WorkOutData(
                "Duration",
                "2 hour",
                AppCompatResources.getDrawable(context, R.drawable.timer_ic)
            )
        )
        workoutDataList.add(
            WorkOutData(
                "Speed",
                "4 Km",
                AppCompatResources.getDrawable(context, R.drawable.baseline_star_outline_24)
            )
        )
        return workoutDataList
    }

    fun getDataOfGlucoseDetail(context: Context): ArrayList<WorkOutData> {
        glucoseDetailList = ArrayList<WorkOutData>()
        glucoseDetailList.add(
            WorkOutData(
                "High",
                "8.5 mmol/L",
                AppCompatResources.getDrawable(context, R.drawable.high_arrow_upward)
            )
        )
        glucoseDetailList.add(
            WorkOutData(
                "Normal",
                "5.5 mmol/L",
                AppCompatResources.getDrawable(context, R.drawable.normal_arrow)
            )
        )
        glucoseDetailList.add(
            WorkOutData(
                "Low",
                "3.5 mmol/L",
                AppCompatResources.getDrawable(context, R.drawable.low_arrow_downward)
            )
        )
        return glucoseDetailList
    }

    fun getSystolicCardData(): SysData {
        return SysData("SYS", "1120", "The meanings of care")
    }

    fun getDiaCardData(): SysData {
        return SysData("DIA", "79", "Growing to meet your needs.")
    }

    fun getMedicineData(context: Context): ArrayList<MedicineData> {
        medicineDataList = ArrayList<MedicineData>()
        medicineDataList.add(MedicineData("Azoptex Obat", "After Lunch", "20mg", AppCompatResources.getDrawable(context, R.drawable.medical_services)))
        medicineDataList.add(MedicineData("Ketoprofen", "Before Lunch", "10mg", AppCompatResources.getDrawable(context, R.drawable.medication_liquid)))
        medicineDataList.add(MedicineData("Paracetamol", "After Lunch", "50mg", AppCompatResources.getDrawable(context, R.drawable.medication_liquid)))
        medicineDataList.add(MedicineData("Other Medicine", "After Lunch", "50mg", AppCompatResources.getDrawable(context, R.drawable.medication_liquid)))
        return medicineDataList
    }

    fun getCompoundsData(): GlucoseCardData {
        compoundsDetail = GlucoseCardData("Glucose:", "5.156 mmol/L", "You're on good state!")
        return compoundsDetail
    }


}