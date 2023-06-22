package com.example.android_practice.main_screen_handle

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_practice.databinding.ItemButtonListBinding
import com.example.android_practice.intent_practice.button_recycle.ActivityButtonModal

class FirstScreenAdapter(private val listOfButton: ArrayList<ActivityButtonModal>): RecyclerView.Adapter<FirstScreenAdapter.FirstScreenViewHolder>() {

    inner class FirstScreenViewHolder(val binding: ItemButtonListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(modal: ActivityButtonModal) {
            binding.buttonText = modal
            binding.btnRecycle.setOnClickListener {
                binding.root.context.startActivity(Intent(binding.root.context, modal.newActivity::class.java))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstScreenViewHolder {
        return FirstScreenViewHolder(ItemButtonListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return listOfButton.count()
    }

    override fun onBindViewHolder(holder: FirstScreenViewHolder, position: Int) {
        holder.bind(listOfButton[position])
    }
}