package com.example.android_practice.recerseKtScreen

import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import com.example.android_practice.R

//@BindingAdapter("Type")
//fun setCardType( textView: TextView, cardType: Boolean) {
//    textView.text = if(cardType) {
//        "${textView.text} mol"
//    } else {
//        "${textView.text} hour"
//    }
//}

public enum class CardType {
    Calories,
    Duration,
    Speed
}