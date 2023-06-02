package com.example.android_practice.intent_practice.activity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_practice.databinding.ActivityFragmentToDataPassBinding
import com.example.android_practice.intent_practice.navigationGraph.modal.ActivityDataHolder

class FragmentToActivityDataPass : AppCompatActivity() {

    private lateinit var binding: ActivityFragmentToDataPassBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentToDataPassBinding.inflate(layoutInflater)
        setContentView(binding.root)

        receiveDataFromFragment()
        receiveDataFromActivity()
    }


    private fun receiveDataFromActivity() {
        val message = intent.extras?.getParcelable("name") as? ActivityDataHolder
        binding.etFullName.hint = message?.data
    }

    private fun receiveDataFromFragment() {
        val intent = intent
        val userName = intent.getStringExtra("userName")
        binding.tvReceivedData.text = userName.toString()

    }
}