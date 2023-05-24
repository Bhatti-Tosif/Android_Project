package com.example.android_practice.uiwidgets

import android.animation.ObjectAnimator
import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RatingBar
import android.widget.SeekBar
import com.example.android_practice.R
import com.example.android_practice.databinding.ActivityProgressBarTryBinding
import com.example.android_practice.databinding.ActivitySpinnerPracticeBinding

class ProgressBarTry : AppCompatActivity() {

    private lateinit var binding: ActivityProgressBarTryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProgressBarTryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.horizontalProgress.max = 100
        val currentProgress = 100
        binding.progressVertical.max = 10
        ObjectAnimator.ofInt(binding.horizontalProgress, "progress", currentProgress).setDuration(5000).start()
        ObjectAnimator.ofInt(binding.progressVertical, "progress", currentProgress).setDuration(5000).start()

        binding.download.setOnClickListener {
            var pd = ProgressDialog(this)
            pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)
            pd.setTitle("Download")
            pd.setMessage("Downloading File")
            pd.show()
            Thread(Runnable {
                var count = 0
                while (count <= 100) {
                    count += 10
                    pd.progress = count
                    Thread.sleep(1000)
                }
                if(count >= 100) {
                    pd.dismiss()
                }
            }).start()
        }

        binding.seekBarDiscrete.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.tvDiscrete.setText("Value = ${progress}")
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })
        binding.seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.tvChangeValue.setText("Value = ${progress}")
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

        binding.ratingBar.setOnRatingBarChangeListener(object : RatingBar.OnRatingBarChangeListener {
            override fun onRatingChanged(ratingBar: RatingBar?, rating: Float, fromUser: Boolean) {
                binding.tvRating.setText("Rating = ${rating}")
            }

        })


    }
}