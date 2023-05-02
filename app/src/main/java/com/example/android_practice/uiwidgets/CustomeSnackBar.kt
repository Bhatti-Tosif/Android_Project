package com.example.android_practice.uiwidgets

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import com.example.android_practice.R
import com.example.android_practice.databinding.ActivityCustomeSnackBarBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.Snackbar.SnackbarLayout

class CustomeSnackBar : AppCompatActivity() {

    private lateinit var binding: ActivityCustomeSnackBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomeSnackBarBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var constraintLayout = findViewById<ConstraintLayout>(R.id.constraint)

        binding.btnCustomSnackBar.setOnClickListener {
            var snackBar = Snackbar.make(constraintLayout, "", Snackbar.LENGTH_INDEFINITE)

            val customView = layoutInflater.inflate(R.layout.custom_snack_view, null)
            snackBar.view.setBackgroundColor(Color.TRANSPARENT)
            val snackBarLayout = snackBar.view as SnackbarLayout
            snackBarLayout.setPadding(0,0,0,0)

            customView.findViewById<TextView>(R.id.tvDismiss).setOnClickListener {
                Toast.makeText(this, "Dismiss Snack Bar", Toast.LENGTH_SHORT).show()
                snackBar.dismiss()
            }
            snackBarLayout.addView(customView)
            snackBar.show()
        }
    }
}