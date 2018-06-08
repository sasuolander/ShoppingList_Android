package com.sasu.shoppinglist

import android.app.Activity
import android.os.Bundle
import android.webkit.WebView

class Instructions: Activity() {
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.insructions)
        val test: WebView = findViewById(R.id.testi)
        test.loadUrl("file:///android_asset/testi.html")
    }
}