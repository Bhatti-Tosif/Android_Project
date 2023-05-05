package com.example.android_practice.listView

import android.annotation.SuppressLint
import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.android_practice.R
import com.example.android_practice.databinding.FragmentStaggeredLayoutManagerBinding

class AdapterCustomList(var context: Context, val dataList: ArrayList<UserDetailData>): BaseAdapter() {
    override fun getCount(): Int {
        return dataList.count()
    }

    override fun getItem(position: Int): Any {
        return dataList[position]
    }

    override fun getItemId(position: Int): Long {
        return dataList[position].imgId.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.custom_list_item, null, false)
        val imageView = inflater.findViewById<ImageView>(R.id.userImage)
        val userName = inflater.findViewById<TextView>(R.id.tvUserName)
        val message = inflater.findViewById<TextView>(R.id.tvMessage)

        imageView.setImageResource(dataList[position].imgId)
        userName.text = dataList[position].name
        message.text = dataList[position].massage

        return inflater
    }
}