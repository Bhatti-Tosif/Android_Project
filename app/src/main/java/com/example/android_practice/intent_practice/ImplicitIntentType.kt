package com.example.android_practice.intent_practice

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Phone
import android.provider.ContactsContract.Contacts
import android.view.View
import com.example.android_practice.R
import com.example.android_practice.databinding.ActivityImplicitIntentTypeBinding

class ImplicitIntentType : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityImplicitIntentTypeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImplicitIntentTypeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnWeb.setOnClickListener(this)
        binding.btnMap.setOnClickListener(this)
        binding.btnContact.setOnClickListener(this)
        binding.btnMessage.setOnClickListener(this)

    }

    @SuppressLint("IntentReset")
    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_web -> {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
                startActivity(intent)
            }
            R.id.btn_map -> {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.7749,-122.4194"))
                startActivity(intent)
            }
            R.id.btn_message-> {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT, "Hello Rahul")
                startActivity(intent)
            }
            R.id.btn_contact -> {
                val intent = Intent(Intent.ACTION_PICK, Contacts.CONTENT_URI)
                intent.type = Phone.CONTENT_TYPE
                startActivity(Intent.createChooser(intent, "header Message"))
            }
        }
    }
}