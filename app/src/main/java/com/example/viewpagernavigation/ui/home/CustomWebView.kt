package com.example.viewpagernavigation.ui.home

import android.content.Context
import android.util.AttributeSet
import android.view.KeyEvent
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.LinearLayout

class CustomWebView : WebView {

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    )

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context) : super(context)

    init {
        layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )

        settings.apply {
            javaScriptCanOpenWindowsAutomatically = true
            javaScriptEnabled = true
            domStorageEnabled = true
            allowContentAccess = true
            allowFileAccess = true
            loadsImagesAutomatically = true
            isFocusable = true
            isFocusableInTouchMode = true
            databaseEnabled = true
            setAppCacheEnabled(true)
        }

        webViewClient = WebViewClient()
    }

    override fun goBack() {
        if (canGoBack()) super.goBack()
    }
}