package com.example.android_practice.listView

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.android_practice.R
import com.google.android.material.snackbar.Snackbar


class SimpleListFragment : Fragment() {

    private lateinit var simpleList: ListView
    private lateinit var name: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val inflate = inflater.inflate(R.layout.fragment_simple_list,container, false)
        simpleList = inflate.findViewById(R.id.simpleList2)

        name = arrayListOf("Harsh", "Parth", "Rahul", "Ruchit", "Tosif", "Meetraj", "Aniket", "Atul", "Ayush",
            "Harsh", "Parth", "Rahul", "Ruchit", "Tosif", "Meetraj", "Aniket", "Atul", "Ayush")

        val listAdapter = ArrayAdapter(inflate.context,android.R.layout.simple_list_item_1, name)
        simpleList.adapter = listAdapter

        simpleList.setOnItemClickListener { parent, view, position, id ->
            Snackbar.make(view, "Hey! " + name[position], Snackbar.LENGTH_SHORT).show()
        }

        return inflate
    }

}