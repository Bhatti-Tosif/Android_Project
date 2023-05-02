package com.example.android_practice.uiwidgets

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.example.android_practice.R
import com.example.android_practice.databinding.ActivityFloatingActionButtonBinding
import com.google.android.material.snackbar.Snackbar

class FloatingActionButton : AppCompatActivity() {

    private lateinit var binding: ActivityFloatingActionButtonBinding

    var isAllVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFloatingActionButtonBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.fabReceive.visibility = View.GONE
        binding.fabCancel.visibility = View.GONE
        binding.tvReceived.visibility = View.GONE
        binding.tvCancel.visibility = View.GONE

        binding.faNotification.shrink()

        binding.faNotification.setOnClickListener {
            if(!isAllVisible) {
                binding.fabReceive.show()
                binding.fabCancel.show()
                binding.tvReceived.visibility = View.VISIBLE
                binding.tvCancel.visibility = View.VISIBLE
                binding.faNotification.extend()
                isAllVisible = true
            } else {
                binding.fabReceive.hide()
                binding.fabCancel.hide()
                binding.tvCancel.visibility = View.GONE
                binding.tvReceived.visibility = View.GONE
                binding.faNotification.shrink()
                isAllVisible = false
            }
        }

        var snackBar = Snackbar.make(view, "Action Snack", Snackbar.LENGTH_SHORT).setAction("Undo", View.OnClickListener {
            Snackbar.make(view, "restored", Snackbar.LENGTH_SHORT).show()
        })




        binding.fabReceive.setOnClickListener {
            Toast.makeText(this,"Received", Toast.LENGTH_SHORT).show()
            Snackbar.make(view, "SnackBar", Snackbar.LENGTH_SHORT).show()
        }
        binding.fabCancel.setOnClickListener{
            Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
            snackBar.show()
        }

        binding.fabCustomSnack.setOnClickListener {
            val customSnackBar = Snackbar.make(view, "Custom SnackBar", Snackbar.LENGTH_SHORT).setAction("Retry", View.OnClickListener {
                Toast.makeText(this, "Please Wait", Toast.LENGTH_SHORT).show()
            })
            customSnackBar.setActionTextColor(Color.RED)
            //val sbView = customSnackBar.view
            customSnackBar.setText("Custom Snack with gray")
            customSnackBar.setMaxInlineActionWidth(2)
            customSnackBar.setTextColor(Color.GREEN)
            customSnackBar.setBackgroundTint(Color.LTGRAY)
            customSnackBar.show()
        }
    }
}