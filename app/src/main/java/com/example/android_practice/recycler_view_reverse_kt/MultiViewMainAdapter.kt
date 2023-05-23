package com.example.android_practice.recycler_view_reverse_kt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.android_practice.databinding.DropDownViewItemBinding
import com.example.android_practice.databinding.HorizontalRecylerImageViewBinding
import com.example.android_practice.databinding.SimpleViewItemListBinding

class MultiViewMainAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var imagesList: ArrayList<Int>

    private var dataList: ArrayList<MultiViewType> = arrayListOf()
    private lateinit var horizontalAdapter: HorizontalAdapter

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            1 -> SimpleViewHolder(SimpleViewItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            2 -> HorizontalViewHolder(HorizontalRecylerImageViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            3 -> DropDownVewHolder(DropDownViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            else -> SimpleViewHolder(SimpleViewItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }

    override fun getItemCount(): Int {
        return dataList.count()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = dataList[position]
        when (holder) {
            is SimpleViewHolder -> holder.bind(item as MultiViewType.SimpleItem)
            is HorizontalViewHolder -> holder.bind(item as MultiViewType.HorizontalItem)
            is DropDownVewHolder -> holder.bind(item as MultiViewType.DropdownItem)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return dataList[position].viewType
    }

    inner class SimpleViewHolder(private val binding: SimpleViewItemListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MultiViewType.SimpleItem) {
            binding.ivProfile.setImageResource(item.profileImage)
            binding.tvUserName.text = item.userName

            itemView.setOnClickListener {
                Toast.makeText(binding.root.context, "Name: "+item.userName, Toast.LENGTH_SHORT).show()
            }
        }
    }

    inner class HorizontalViewHolder(private val binding: HorizontalRecylerImageViewBinding): RecyclerView.ViewHolder(binding.root) {
        init {
            val snapHelper = LinearSnapHelper()
            snapHelper.attachToRecyclerView(binding.rvHorizontalPost)
            binding.rvHorizontalPost.layoutManager = LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
        }
        fun bind(item: MultiViewType.HorizontalItem) {
            horizontalAdapter = HorizontalAdapter()
            binding.rvHorizontalPost.adapter = horizontalAdapter
            imagesList = item.postImages
            horizontalAdapter.submitList(imagesList)
        }
    }

    inner class DropDownVewHolder(private val binding: DropDownViewItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MultiViewType.DropdownItem) {
            binding.ivProfile.setImageResource(item.profileImage)
            binding.tvUserName.text = item.userName
            binding.tvComment.text = item.comment

            itemView.setOnClickListener {
                if (item.isExpand) {
                    binding.tvReadComment.visibility = View.VISIBLE
                    collapsedComment()
                } else {
                    binding.tvReadComment.visibility = View.GONE
                    expandComment()
                }
                item.isExpand = !item.isExpand
            }
        }
        private fun expandComment() {
            binding.tvComment.visibility = View.VISIBLE
        }
        private fun collapsedComment() {
            binding.tvComment.visibility = View.GONE
        }
    }

    fun submitList(newList: ArrayList<MultiViewType>) {
        val diffUtil = MultiViewCallBack(dataList, newList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        dataList.clear()
        dataList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

}