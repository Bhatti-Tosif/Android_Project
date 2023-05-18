package com.example.android_practice.screens.tagB

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.RatingBar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.android_practice.R
import com.example.android_practice.databinding.PastReservationItemBinding
import com.example.android_practice.screens.tagB.dataModel.Data
import com.example.android_practice.screens.tagB.dataModel.RentalModel
import kotlinx.coroutines.NonDisposableHandle.parent
import java.text.FieldPosition

class RentalViewHolder(val binding: PastReservationItemBinding, private val changeDetail: (Int) -> Unit): RecyclerView.ViewHolder(binding.root) {

    fun bind(dataModel: RentalModel, position: Int) {
        binding.prData = dataModel
        binding.executePendingBindings()
        setUpRating(dataModel, position)

        binding.btnDetail.setOnClickListener {
            changeDetail(position)
        }

        binding.checkbox.setOnCheckedChangeListener { p0, p1 ->
            Data.getRentalData()[position].isRented = p1
        }
    }

    private fun setUpRating(dataModel: RentalModel, position: Int) {
        if(dataModel.rating == null) {
            binding.tvRating.setText(R.string.rate_now)
            binding.tvRating.setTextColor(binding.root.resources.getColor(R.color.deepAqua))
            binding.tvRating.isEnabled = true
            binding.tvRating.isClickable = true
            binding.tvRating.setCompoundDrawables(null,null,null,null)
            binding.tvRating.setOnClickListener {

                val builder = AlertDialog.Builder(binding.root.context).create()
                val view = LayoutInflater.from(binding.root.context).inflate(R.layout.custom_alert_rental_detail, null)
                builder.setView(view)

                val cancelButton = view.findViewById<Button>(R.id.btnCancel)
                cancelButton.setOnClickListener {
                    builder.dismiss()
                }
                val ratingBar = view.findViewById<RatingBar>(R.id.ratingBar)

                val rateButton = view.findViewById<Button>(R.id.btnDone)

                rateButton.setOnClickListener {
                    binding.tvRating.text = ratingBar.rating.toString()
                    binding.tvRating.setCompoundDrawablesWithIntrinsicBounds(
                        R.drawable.baseline_star_24,
                        0,
                        0,
                        0
                    )
                    binding.prData?.rating = ratingBar.rating.toDouble()
                    Data.getRentalData()[position].rating = ratingBar.rating.toDouble()
                    builder.dismiss()
                }
                builder.setCanceledOnTouchOutside(true)
                builder.show()
            }
        } else {
            binding.tvRating.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_star_24, 0, 0, 0)
        }
    }
}