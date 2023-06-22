package com.example.android_practice.intent_practice.button_recycle

import com.example.android_practice.intent_practice.ExplicitIntent
import com.example.android_practice.intent_practice.SecondLaunchActivity
import com.example.android_practice.intent_practice.activity.ActivityFragmentDataPassing
import com.example.android_practice.intent_practice.activity.BroadCastReceiverPractice
import com.example.android_practice.intent_practice.activity.FragmentChangerActivity
import com.example.android_practice.intent_practice.activity.FragmentToFragmentDataPassing
import com.example.android_practice.intent_practice.activity.ImplicitIntentPractice
import com.example.android_practice.intent_practice.activity.IntentFilterPractice
import com.example.android_practice.intent_practice.activity.PendingIntentPractice
import com.example.android_practice.webServices.activity.MeetingAppMainActivity
import com.example.android_practice.intent_practice.navigationGraph.activity.NestedNavigationGraph
import com.example.android_practice.intent_practice.navigationGraph.activity.WebViewPractice

object Helper {
    fun getButtonData(): ArrayList<ActivityButtonModal> {
        val listOfActivityButtonModal = ArrayList<ActivityButtonModal>()
        listOfActivityButtonModal.add(ActivityButtonModal("Activity LifeCycle", SecondLaunchActivity()))
        listOfActivityButtonModal.add(ActivityButtonModal("Intent", ExplicitIntent()))
        listOfActivityButtonModal.add(ActivityButtonModal("Fragment", FragmentChangerActivity()))
        listOfActivityButtonModal.add(ActivityButtonModal("Fragment Data Passing", FragmentToFragmentDataPassing()))
        listOfActivityButtonModal.add(ActivityButtonModal("Activity Fragment DataPassing",ActivityFragmentDataPassing()))
        listOfActivityButtonModal.add(ActivityButtonModal("Implicit Intent",ImplicitIntentPractice()))
        listOfActivityButtonModal.add(ActivityButtonModal("Intent Filter",IntentFilterPractice()))
        listOfActivityButtonModal.add(ActivityButtonModal("Broad Cast Receiver", BroadCastReceiverPractice()))
        listOfActivityButtonModal.add(ActivityButtonModal("Pending Intent", PendingIntentPractice()))
        listOfActivityButtonModal.add(ActivityButtonModal("Bottom Navigation", MeetingAppMainActivity()))
        listOfActivityButtonModal.add(ActivityButtonModal("WebView", WebViewPractice()))
        listOfActivityButtonModal.add(ActivityButtonModal("Nested Graph", NestedNavigationGraph()))


        return listOfActivityButtonModal
    }
}