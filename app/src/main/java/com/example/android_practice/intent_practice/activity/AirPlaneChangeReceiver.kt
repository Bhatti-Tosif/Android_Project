package com.example.android_practice.intent_practice.activity

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirPlaneChangeReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        val isAirPlaneModeEnabled = intent?.getBooleanExtra("state", false) ?: return

        if (isAirPlaneModeEnabled) {
            Toast.makeText(context, "AirPlane Mode Enabled", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, "AirPlane Mode Disabled", Toast.LENGTH_LONG).show()
        }
    }
}