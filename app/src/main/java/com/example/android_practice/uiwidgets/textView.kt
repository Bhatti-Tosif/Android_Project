package com.example.android_practice.uiwidgets

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import com.example.android_practice.R
import com.example.android_practice.databinding.ActivityTextViewBinding
import org.w3c.dom.Text

class textView : AppCompatActivity() {

    private var _binding: ActivityTextViewBinding? = null

    private  val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityTextViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val text = "Bold italic strike green with span"
        var ss = SpannableString(text)
        ss.setSpan(
            StyleSpan(Typeface.BOLD),
            0,
            3,
            Spannable.SPAN_COMPOSING
        )
        ss.setSpan(
            StyleSpan(Typeface.ITALIC),
            5,
            10,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        ss.setSpan(
            StyleSpan(Typeface.BOLD_ITALIC),
            12,
            17,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        ss.setSpan(
            ForegroundColorSpan(Color.GREEN),
            19,
            23,
            Spannable.SPAN_COMPOSING
        )
        binding.multicolor?.text = ss

        binding.longPress?.setOnLongClickListener{
            binding.longPress?.text = "long Pressed"
            return@setOnLongClickListener true
        }


    }
}