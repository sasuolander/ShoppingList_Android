package com.sasu.shoppinglist

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import java.util.HashSet

import com.sasu.shoppinglist.NewShoppingItem.Companion.Items

class ShoppingListMainMenu : AppCompatActivity() {

    internal var adapter: ArrayAdapter<String>?=null
    val mypreference = "mypref"
    val lista = "lista"

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.shoppingmenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.addItem_menu -> {
                //Log.d("test_user", "Add Item");
                val siirtoseuraavaanNewShoppingItem = Intent(this@ShoppingListMainMenu, NewShoppingItem::class.java)
                this.startActivity(siirtoseuraavaanNewShoppingItem)
                return true
            }
            R.id.instructions_menu -> {
                //Log.d("test_user", "Instruction");
                val siirtoseuraavaanInstructions = Intent(this@ShoppingListMainMenu, Instructions::class.java)
                this.startActivity(siirtoseuraavaanInstructions)
                return true
            }
            R.id.SaveData -> {
                val sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE)
                val editor = sharedpreferences.edit()
                editor.putStringSet(lista, NewShoppingItem.Items)
                editor.apply()
                return super.onOptionsItemSelected(item)
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    fun naytaToast(teksti: String) {
        val aika = Toast.LENGTH_LONG
        val context = applicationContext
        val toast = Toast.makeText(context, teksti, aika)
        toast.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        NewShoppingItem.Items.addAll(Load_data())
        setContentView(R.layout.activity_shopping_list_mainenu)
        val lista:ListView = findViewById(R.id.ShoppingItem)
        if ( Items.size > 0) {
            adapter = ArrayAdapter<String>(this,
                    android.R.layout.simple_expandable_list_item_1,
                    Items.toTypedArray()
                    )
            lista.adapter
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
        save_data()
    }

    protected fun Load_data(): Set<String> {
        val sharedpreferences = getPreferences(Context.MODE_PRIVATE)
        return sharedpreferences.getStringSet(lista, HashSet())
    }

    fun save_data() {
        val sharedpreferences = getPreferences(Context.MODE_PRIVATE)
        val editor = sharedpreferences.edit()
        editor.putStringSet(lista, NewShoppingItem.Items)
        editor.apply()
    }


}
