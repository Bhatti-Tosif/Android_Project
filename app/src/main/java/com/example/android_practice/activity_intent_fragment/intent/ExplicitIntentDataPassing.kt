package com.example.android_practice.activity_intent_fragment.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_practice.R
import com.example.android_practice.databinding.ActivityExplicitIntentDataPassingBinding

class ExplicitIntentDataPassing : AppCompatActivity() {

    private lateinit var binding: ActivityExplicitIntentDataPassingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExplicitIntentDataPassingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSendData.setOnClickListener {
            val intent = Intent(this, ExplicitDataReceiver::class.java)
            intent.putExtra("name", binding.etEnterName.text.toString())
            intent.putExtra("surname", binding.etEnterSurname.text.toString())
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                val result = data?.getStringExtra("result")
                binding.tvUserID.text = " " + result
            }
            if (resultCode == RESULT_CANCELED) {
                binding.tvUserID.text = " No User generated"
            }
        }
    }
}