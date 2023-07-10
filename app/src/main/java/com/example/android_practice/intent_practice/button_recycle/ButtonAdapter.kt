package com.example.android_practice.intent_practice.button_recycle

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_practice.databinding.ItemButtonListBinding

class ButtonAdapter(private val listOfButton: ArrayList<ActivityButtonModal>): RecyclerView.Adapter<ButtonAdapter.ButtonViewHolder>() {

    inner class ButtonViewHolder(val binding: ItemButtonListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(buttonModal: ActivityButtonModal) {
            binding.buttonText = buttonModal
            binding.btnRecycle.setOnClickListener {
                binding.root.context.startActivity(Intent(binding.root.context, buttonModal.newActivity::class.java))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ButtonViewHolder {
        return ButtonViewHolder(ItemButtonListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return listOfButton.count()
    }

    override fun onBindViewHolder(holder: ButtonViewHolder, position: Int) {
        holder.bind(listOfButton[position])
    }
}