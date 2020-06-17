package com.example.viewpagernavigation.ui.home

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.Toolbar
import android.view.MenuItem
import android.view.View
import android.webkit.*
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController

import com.example.viewpagernavigation.R
import com.example.viewpagernavigation.ui.MainActivity
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {

    lateinit var webView: CustomWebView

    private var isVisibleForUser = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val toolbar = requireActivity().findViewById<Toolbar>(R.id.toolbar_home)
        toolbar.inflateMenu(R.menu.menu_home)
        toolbar.setOnMenuItemClickListener(this::onOptionsItemSelected)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        webView = web_view
        webView.webChromeClient = WebChromeClient()
        webView.webViewClient = WebViewClient()

        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true)
        } else {
            CookieManager.getInstance().setAcceptCookie(true)
        }

        web_view.loadUrl("https://yandex.ru")

        web_view.setOnKeyListener { _, p1, _ ->
            if (isVisibleForUser && web_view.canGoBack()) {
                if (p1 == KeyEvent.KEYCODE_BACK) {
                    web_view.goBack()
                }
                true
            } else {
                false
            }
        }
    }

    override fun onResume() {
        super.onResume()
        isVisibleForUser = true
    }

    override fun onPause() {
        super.onPause()
        isVisibleForUser = false
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val destination = when (item.itemId) {
            R.id.search -> R.id.action_search
            else -> null
        }

        return if (destination != null) findNavController().navigate(destination).let { true }
        else super.onOptionsItemSelected(item)
    }
}
