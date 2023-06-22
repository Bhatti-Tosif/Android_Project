package com.example.android_practice.main_screen_handle

import com.example.android_practice.intent_practice.button_recycle.ActivityButtonModal
import com.example.android_practice.intent_practice.button_recycle.ActivityRecycleButton
import com.example.android_practice.layoutPractice.ConstraintLayout
import com.example.android_practice.layoutPractice.FrameLayoutPractice
import com.example.android_practice.layoutPractice.GridLayoutPractice
import com.example.android_practice.layoutPractice.RelativeLayout
import com.example.android_practice.listView.SimpleListView
import com.example.android_practice.recerseKtScreen.activity.TreatHomeScreen
import com.example.android_practice.recycler_view.RecyclerViewPractice
import com.example.android_practice.screens.BankEcLaunchScreen
import com.example.android_practice.screens.tagB.PastReservationDetail
import com.example.android_practice.uiwidgets.AllWidgets
import com.example.android_practice.webServices.activity.MainWebServices

object ButtonList {

    fun getButtonList(): ArrayList<ActivityButtonModal> {
        val listOfButtonModal = ArrayList<ActivityButtonModal>()
        listOfButtonModal.add(ActivityButtonModal("Constraint Layout", ConstraintLayout()))
        listOfButtonModal.add(ActivityButtonModal("Relative Layout", RelativeLayout()))
        listOfButtonModal.add(ActivityButtonModal("Screen", BankEcLaunchScreen()))
        listOfButtonModal.add(ActivityButtonModal("UiComponents", AllWidgets()))
        listOfButtonModal.add(ActivityButtonModal("Coordinator Layout", com.example.android_practice.layoutPractice.CoordinatorLayout()))
        listOfButtonModal.add(ActivityButtonModal("Grid Layout", GridLayoutPractice()))
        listOfButtonModal.add(ActivityButtonModal("Frame Layout", FrameLayoutPractice()))
        listOfButtonModal.add(ActivityButtonModal("RecyclerView", RecyclerViewPractice()))
        listOfButtonModal.add(ActivityButtonModal("ListView", SimpleListView()))
        listOfButtonModal.add(ActivityButtonModal("TagB Design", PastReservationDetail()))
        listOfButtonModal.add(ActivityButtonModal("Reverse kt Design", TreatHomeScreen()))
        listOfButtonModal.add(ActivityButtonModal("Intent Practice", ActivityRecycleButton()))
        listOfButtonModal.add(ActivityButtonModal("WebServices", MainWebServices()))

        return listOfButtonModal

    }
}