package com.example.android_practice.recycler_view_reverse_kt

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android_practice.databinding.ItemListOfCommentBinding
import com.example.android_practice.recycler_view_reverse_kt.data_modal.CommentDataModal

class CommentAdapter: RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {

    private val commentDataList: ArrayList<CommentDataModal> = ArrayList<CommentDataModal>()

    inner class CommentViewHolder(val binding: ItemListOfCommentBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CommentDataModal) {
            binding.commentData = item
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder = CommentViewHolder(
        ItemListOfCommentBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int {
        return commentDataList.count()
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) = holder.bind(commentDataList[position])

    fun submitList(newList: ArrayList<CommentDataModal>) {
        val diffUtil = CommentCallBack(commentDataList, newList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        commentDataList.clear()
        commentDataList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

}