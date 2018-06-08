package com.sasu.shoppinglist

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.util.HashSet

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