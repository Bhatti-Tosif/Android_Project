package com.example.android_practice.webServices.Utils

import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.coroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class DebouncingQueryTextListener(lifecycle: Lifecycle, private val onDebouncingQueryTextChange: (String?) -> Unit): SearchView.OnQueryTextListener {

    private val debouncingPeriod:Long = 500
    private val coroutineScope = lifecycle.coroutineScope
    private var searchJob: Job? = null

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        searchJob?.cancel()
        searchJob = coroutineScope.launch {
            newText?.let {
                delay(debouncingPeriod)
                onDebouncingQueryTextChange(newText)
            }
        }
        return false
    }
}