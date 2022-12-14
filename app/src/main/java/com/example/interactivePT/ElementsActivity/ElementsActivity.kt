package com.example.interactivePT.ElementsActivity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.example.interactivePT.PresetInformation.PresetInformation
import com.example.interactivePT.R
import com.google.android.material.navigation.NavigationView


class ElementsActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private val presetInformation = PresetInformation()
    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.elements_activity)
        drawerLayout = findViewById(R.id.my_drawer_layout)
        navigationView = findViewById(R.id.my_nav_view)
        actionBarDrawerToggle =
            ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)
        val allElements = presetInformation.getElements()

        for (element in allElements) {
            //Sets info string
            var item = element.value
            var itemString = item.symbol + " " + item.name + " " + item.atomicNumber + " " + item.atomicMass + " " + item.meltingPoint + " " + item.boilingPoint + " " + item.yearDiscovered
            //Iterates and set click listener for all elements
            var buttonName = "elementButton" + element.key

            var resourceId = this.resources.getIdentifier(buttonName, "id", this.packageName)
            button = findViewById(resourceId)

            button.setOnClickListener{
                //Create Intent
                val i = Intent(this, ElementFocusActivity::class.java)
                i.putExtra(INFORMATION, itemString)
                i.putExtra(DISCOVERER, item.discoveredBy)
                i.putExtra(Desc, item.description)
                startActivity(i)
                Log.d("BUTTON", "BUTTON CLICKED " + itemString)
            }
            Log.d("ELEMENTS", element.toString())
        }



        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)

        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            //Decides action based on which menu item is called
            Log.d("Navigation_Menu", item.itemId.toString())
            true
        } else super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_elements -> drawerLayout.close()
            R.id.nav_gems -> goToGems()
            R.id.nav_compounds -> goToCompounds()
        }
        return true
    }

    //Goes to GemsActivity
    fun goToGems() {
        val i = Intent(this, GemsActivity::class.java)
        startActivity(i)
    }

    //Goes to CompoundsActivity
    fun goToCompounds() {
        val i = Intent(this, CompoundsActivity::class.java)
        startActivity(i)
    }

    companion object {
        const val INFORMATION = "ATOMIC_SYMBOL"
        const val DISCOVERER = "DISCOVERER"
        const val Desc = "Desc"
    }
}