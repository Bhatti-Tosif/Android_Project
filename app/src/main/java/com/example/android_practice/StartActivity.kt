package com.example.android_practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.android_practice.databinding.ActivityStartBinding
import com.example.android_practice.intent_practice.button_recycle.ActivityRecycleButton
import com.example.android_practice.layoutPractice.CoordinatorLayout
import com.example.android_practice.layoutPractice.FrameLayoutPractice
import com.example.android_practice.layoutPractice.GridLayoutPractice
import com.example.android_practice.layoutPractice.LayoutPractice
import com.example.android_practice.layoutPractice.RelativeLayout
import com.example.android_practice.listView.SimpleListView
import com.example.android_practice.recerseKtScreen.activity.TreatHomeScreen
import com.example.android_practice.recycler_view.RecyclerViewPractice
import com.example.android_practice.screens.BankEcLaunchScreen
import com.example.android_practice.screens.tagB.PastReservationDetail
import com.example.android_practice.uiwidgets.AllWidgets
import com.example.android_practice.webServices.activity.MainWebServices

class StartActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityStartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnScreens.setOnClickListener(this)
        binding.btnUiComponents.setOnClickListener(this)
        binding.btnCoordinate.setOnClickListener(this)
        binding.btnLinearLayout.setOnClickListener(this)
        binding.btnRelativeLayout.setOnClickListener(this)
        binding.btnConstraintLayout.setOnClickListener(this)
        binding.btnCoordinate.setOnClickListener(this)
        binding.btnGridLayout.setOnClickListener(this)
        binding.btnFrameLayout.setOnClickListener(this)
        binding.btnRecyclerView.setOnClickListener(this)
        binding.btnListView.setOnClickListener(this)
        binding.btnTagB.setOnClickListener(this)
        binding.btnReverseKt.setOnClickListener(this)
        binding.btnIntent.setOnClickListener(this)
        binding.btnWebServices.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.btnConstraintLayout.id -> {
                val intent = Intent(this, CoordinatorLayout::class.java)
                startActivity(intent)
            }
            binding.btnScreens.id -> {
                val intent = Intent(this@StartActivity, BankEcLaunchScreen::class.java)
                startActivity(intent)
            }
            binding.btnUiComponents.id -> {
                val intent = Intent(this@StartActivity, AllWidgets::class.java)
                startActivity(intent)
            }
            binding.btnLinearLayout.id -> {
                val intent = Intent(this@StartActivity, LayoutPractice::class.java)
                startActivity(intent)
            }
            binding.btnRelativeLayout.id -> {
                val intent = Intent(this@StartActivity, RelativeLayout::class.java)
                startActivity(intent)
            }
            binding.btnGridLayout.id -> {
                val intent = Intent(this@StartActivity, GridLayoutPractice::class.java)
                startActivity(intent)
            }
            binding.btnCoordinate.id -> {
                val intent = Intent(this@StartActivity, CoordinatorLayout::class.java)
                startActivity(intent)
            }
            binding.btnFrameLayout.id -> {
                val intent = Intent(this@StartActivity, FrameLayoutPractice::class.java)
                startActivity(intent)
            }
            binding.btnRecyclerView.id -> {
                val intent = Intent(this@StartActivity, RecyclerViewPractice::class.java)
                startActivity(intent)
            }
            binding.btnListView.id -> {
                val intent = Intent(this@StartActivity, SimpleListView::class.java)
                startActivity(intent)
            }
            binding.btnTagB.id -> {
                val intent = Intent(this, PastReservationDetail::class.java)
                startActivity(intent)
            }
            binding.btnReverseKt.id -> {
                val intent = Intent(this, TreatHomeScreen::class.java)
                startActivity(intent)
            }
            binding.btnIntent.id -> {
                val intent = Intent(this, ActivityRecycleButton::class.java)
                startActivity(intent)
            }
            binding.btnWebServices.id -> {
                val intent = Intent(this, MainWebServices::class.java)
                startActivity(intent)
            }
            else -> {
                print("wrong")
            }
        }
    }
}