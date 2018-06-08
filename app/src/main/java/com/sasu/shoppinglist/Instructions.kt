package com.sasu.shoppinglist

import android.app.Activity
import android.os.Bundle
import android.webkit.WebView
import com.sasu.shoppinglistjava.R

/**
 * Created by sasu on 8.6.2018.
 */
class Instructions :Activity() {
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.insructions)
        val test: WebView = findViewById(R.id.testi)
        test.loadUrl("file:///android_asset/testi.html")
    }
}