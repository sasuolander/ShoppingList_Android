package com.sasu.shoppinglist

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.widget.Button
import android.widget.EditText
import com.sasu.shoppinglistjava.R
import java.util.HashSet

/**
 * Created by sasu on 8.6.2018.
 */
class NewShoppingItem : Activity() {

    companion object {
        var Items: MutableSet<String> = HashSet() }

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
        setContentView(R.layout.newshoppingitem)
        val btAddItem: Button = findViewById(R.id.btadd)

        btAddItem.setOnClickListener {
            val Innimi: EditText = findViewById(R.id.addItemText)
            //siirtyminen
            val nimi = Innimi.text.toString()
            Items.add(nimi)
            startActivity(Intent(this@NewShoppingItem, ShoppingListMainMenu::class.java))
        }
    }
}