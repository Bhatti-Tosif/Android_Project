package com.example.android_practice.intent_practice.navigationGraph.activity

import android.annotation.SuppressLint
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.SearchView
import com.example.android_practice.databinding.ActivityWebViewPracticeBinding

class WebViewPractice : AppCompatActivity() {

    private lateinit var binding: ActivityWebViewPracticeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewPracticeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpWebView()
        setupSearch()
    }
    @SuppressLint("SetJavaScriptEnabled")
    private fun setUpWebView() {
        binding.webView.loadUrl("https://www.google.com/")
        binding.webView.settings.javaScriptEnabled = true

        binding.webView.webViewClient = object : WebViewClient() {

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                binding.progressBar.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                binding.progressBar.visibility = View.GONE
            }
        }
    }

    private fun setupSearch() {
        binding.svForSite.maxWidth = Int.MAX_VALUE
        binding.svForSite.queryHint = "Search any keyword"

        binding.svForSite.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.svForSite.clearFocus()
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if ((newText?.length ?: 0) > 0) {
                    binding.webView.findAllAsync(newText.toString())
                    binding.ibGoBack.visibility = View.VISIBLE
                    binding.ibGoForward.visibility = View.VISIBLE

                } else {
                    binding.webView.clearMatches()
                    binding.ibGoBack.visibility = View.GONE
                    binding.ibGoForward.visibility = View.GONE
                }
                return true
            }

        })

        binding.ibGoForward.setOnClickListener {
            binding.webView.findNext(true)
        }
        binding.ibGoBack.setOnClickListener {
            binding.webView.findNext(false)
        }
    }

 
    override fun onBackPressed() {
        if (binding.webView.canGoBack()) {
            binding.webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}