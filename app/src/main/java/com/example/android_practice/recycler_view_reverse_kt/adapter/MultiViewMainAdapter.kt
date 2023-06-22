package com.example.android_practice.recycler_view_reverse_kt.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.android_practice.databinding.HorizontalRecylerImageViewBinding
import com.example.android_practice.databinding.ItemDropDownViewTypeBinding
import com.example.android_practice.databinding.ItemSimpleViewTypeListBinding
import com.example.android_practice.recycler_view_reverse_kt.data_modal.CommentDataModal
import com.example.android_practice.recycler_view_reverse_kt.data_modal.MultiViewType
import com.example.android_practice.recycler_view_reverse_kt.data_modal.PostModel
import com.example.android_practice.recycler_view_reverse_kt.data_modal.ViewType
class MultiViewMainAdapter(
    val onPostClick: (Int) -> Unit,
    val onSimpleViewClick: (MultiViewType.SimpleItem) -> Unit,
    val onDropDownClick: (ItemDropDownViewTypeBinding, MultiViewType.DropdownItem) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var dataList: ArrayList<MultiViewType> = arrayListOf()
    private lateinit var horizontalAdapter: HorizontalAdapter
    private lateinit var commentAdapter: CommentAdapter
    private lateinit var commentList: ArrayList<CommentDataModal>

    private var getCount = 1
    private var onCreate = 1
    private var onBind = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = ViewType.values()[viewType]
        Log.d("REC create", onCreate.toString())
        onCreate += 1
        return when (view) {
            ViewType.SimpleView -> SimpleViewHolder(
                ItemSimpleViewTypeListBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )

            ViewType.HorizontalView -> HorizontalViewHolder(
                HorizontalRecylerImageViewBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )

            ViewType.DropDownView -> DropDownVewHolder(
                ItemDropDownViewTypeBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        }
    }

    override fun getItemCount(): Int {
        Log.d("Recycler count", getCount.toString())
        getCount += 1
        return dataList.count()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = dataList[position]
        Log.d("Recycler bind", onBind.toString())
        onBind += 1
        when (holder) {
            is SimpleViewHolder -> holder.bind(item as MultiViewType.SimpleItem)
            is HorizontalViewHolder -> holder.bind(item as MultiViewType.HorizontalItem)
            is DropDownVewHolder -> holder.bind(item as MultiViewType.DropdownItem)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return dataList[position].viewType.ordinal
    }

    inner class SimpleViewHolder(private val binding: ItemSimpleViewTypeListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MultiViewType.SimpleItem) {
            binding.simpleTypeData = item
            binding.executePendingBindings()
            itemView.setOnClickListener {
                onSimpleViewClick(item)
            }
        }
    }

    inner class HorizontalViewHolder(private val binding: HorizontalRecylerImageViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            val snapHelper = LinearSnapHelper()
            snapHelper.attachToRecyclerView(binding.rvHorizontalPost)
            binding.rvHorizontalPost.layoutManager =
                LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
        }

        fun bind(item: MultiViewType.HorizontalItem) {
            horizontalAdapter = HorizontalAdapter(onPostClick)
            binding.rvHorizontalPost.adapter = horizontalAdapter
            horizontalAdapter.submitList(item.postImages)
        }
    }

    inner class DropDownVewHolder(private val binding: ItemDropDownViewTypeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.rvListOfComment.layoutManager =
                LinearLayoutManager(binding.root.context, LinearLayoutManager.VERTICAL, false)
        }

        fun bind(item: MultiViewType.DropdownItem) {
            binding.dropDownData = item
            binding.executePendingBindings()

            commentAdapter = CommentAdapter()
            binding.rvListOfComment.adapter = commentAdapter

            commentList = item.commentModal
            commentAdapter.submitList(commentList)

            itemView.setOnClickListener {
                onDropDownClick(binding, item)
            }
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

