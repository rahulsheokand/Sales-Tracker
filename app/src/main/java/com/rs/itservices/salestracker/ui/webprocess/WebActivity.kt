package com.rs.itservices.salestracker.ui.webprocess

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.rs.itservices.salestracker.R
import com.rs.itservices.salestracker.databinding.ActivityWebBinding
import com.rs.itservices.salestracker.utils.AppConstants

/**
 * created by **lovepreetkaur240@gmail.com** 5 July,2021
 */

class WebActivity : AppCompatActivity() {
   lateinit var binding : ActivityWebBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setWebApp()
        var img_back: ImageView = findViewById(R.id.img_back)
        img_back.setOnClickListener {
            onBackPressed()
        }
    }

    fun setWebApp(){
        binding.webView.getSettings().setJavaScriptEnabled(true)
        binding.webView.getSettings().setLoadWithOverviewMode(true)
        binding.webView.getSettings().setUseWideViewPort(true)
        binding.webView.getSettings().setBuiltInZoomControls(true)
        binding.webView.getSettings().setPluginState(WebSettings.PluginState.ON)
        binding.webView.setWebViewClient(AppWebViewClient())
        binding.webView.loadUrl(AppConstants.webUrl)
    }

    private class AppWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            return false
        }
    }
}