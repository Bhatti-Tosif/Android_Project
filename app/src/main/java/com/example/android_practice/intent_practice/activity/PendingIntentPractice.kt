package com.example.android_practice.intent_practice.activity

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_practice.databinding.ActivityPandingIntentPracticeBinding

class PendingIntentPractice : AppCompatActivity() {

    private lateinit var binding: ActivityPandingIntentPracticeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPandingIntentPracticeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSetAlarm.setOnClickListener {
            startNewActivity()
        }
    }

    private fun startNewActivity() {
        val intent = Intent(this, PendingIntentReceiver::class.java)
        val time = binding.etEnterTime.text.toString()
        intent.putExtra("time", time)
        val pendingIntent = PendingIntent.getBroadcast(
            applicationContext,
            1,
            intent,
            PendingIntent.FLAG_CANCEL_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + time.toInt()*1000, pendingIntent)
    }
}