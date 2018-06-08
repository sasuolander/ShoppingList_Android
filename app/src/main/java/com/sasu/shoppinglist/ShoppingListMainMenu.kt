package com.sasu.shoppinglist

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import java.util.HashSet

import com.sasu.shoppinglist.NewShoppingItem.Companion.Items

class ShoppingListMainMenu: AppCompatActivity() {

    private var adapter: ArrayAdapter<String>?=null
    private val lista = "lista"

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.shoppingmenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
            R.id.addItem_menu -> {
                this.startActivity(Intent(this@ShoppingListMainMenu, NewShoppingItem::class.java))
                 true }
            R.id.instructions_menu -> {
                this.startActivity(Intent(this@ShoppingListMainMenu, Instructions::class.java))
                 true }
            R.id.SaveData -> {
                saveData()
                 super.onOptionsItemSelected(item) }
            else ->  super.onOptionsItemSelected(item)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        NewShoppingItem.Items.addAll(loadData())
        setContentView(R.layout.activity_shopping_list_mainenu)
        val lista:ListView = findViewById(R.id.ShoppingItem)
        if ( Items.size > 0) {
            adapter = ArrayAdapter<String>(this,
                    android.R.layout.simple_expandable_list_item_1,
                    Items.toTypedArray()
                    )
            lista.adapter =adapter
        }
        val btAdd: Button  = findViewById(R.id.addItem)
        val btIntruction: Button = findViewById(R.id.instructions)

        btAdd.setOnClickListener {
            startActivity(Intent(this@ShoppingListMainMenu, NewShoppingItem::class.java))
        }

        btIntruction.setOnClickListener {
            startActivity(Intent(this@ShoppingListMainMenu, Instructions::class.java))
        }
    }

    override fun onPause() {
        super.onPause()
        saveData()
    }

    private fun loadData(): Set<String> {
        val sharedpreferences = getPreferences(Context.MODE_PRIVATE)
        return sharedpreferences.getStringSet(lista, HashSet())
    }

    private fun saveData() {
        val sharedpreferences = getPreferences(Context.MODE_PRIVATE)
        val editor = sharedpreferences.edit()
        editor.putStringSet(lista, NewShoppingItem.Items)
        editor.apply()
    }

    /*
    fun naytaToast(teksti: String) {
        val aika = Toast.LENGTH_LONG
        val context = applicationContext
        val toast = Toast.makeText(context, teksti, aika)
        toast.show()
    }
    */
}