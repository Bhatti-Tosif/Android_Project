package com.example.android_practice.intent_practice.activity

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class PendingIntentReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val res = intent?.getStringExtra("time")

        val intentStart = Intent(context, ImplicitIntentPractice::class.java).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK).apply {
            putExtra("from_notification", true)
        }
        context?.startActivity(intentStart)
        Toast.makeText(context, "Start Activity After: $res", Toast.LENGTH_SHORT).show()
    }
}