package com.example.android_practice.uiwidgets

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.android_practice.R

class CountryArrayAdapter(context: Context, items: ArrayList<CountryDataSource>) : BaseAdapter() {
    private val context: Context
    private val items: ArrayList<CountryDataSource>
    init {
        this.context = context
        this.items = items
    }
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView: View? = convertView
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.custome_spinner, parent,false)
        }
        val countryImage = convertView?.findViewById(R.id.countryImage) as ImageView
        val countryName = convertView.findViewById(R.id.countryName) as TextView
        countryImage.setImageResource(items[position].image)
        countryName.text = items[position].name
        return convertView
    }


}