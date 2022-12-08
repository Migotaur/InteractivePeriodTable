package com.example.interactivePT.ElementsActivity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.interactivePT.PresetInformation.PresetInformation
import com.example.interactivePT.R
import com.google.android.material.internal.NavigationMenu
import com.google.android.material.navigation.NavigationView





class GemsActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private val presetInformation = PresetInformation()

    lateinit var button: Button
    lateinit var eButton: Button
    lateinit var formula: TextView

    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gems_activity)
        drawerLayout = findViewById(R.id.my_drawer_layout)
        navigationView = findViewById(R.id.my_nav_view)
        formula = findViewById(R.id.formula_text)
        actionBarDrawerToggle =
            ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)
        val allGems = presetInformation.getGems()

        for (gem in allGems) {
            //Sets info string
            var item = gem.value

            //Iterates and set click listener for all elements
            var buttonName = "button_" + item.name

            var resourceId = this.resources.getIdentifier(buttonName, "id", this.packageName)
            button = findViewById(resourceId)

            button.setOnClickListener{
                //Clears table
                for(i in 1..118){
                    var eButtonName = "elementButton" + i
                    var eResourceId = this.resources.getIdentifier(eButtonName, "id", this.packageName)
                    eButton = findViewById(eResourceId)
                    eButton.setBackgroundColor(Color.WHITE)
                }

                //Sets formula
                formula.setText(item.name + ": " + item.formula)

                //Checks elements in the table
                var gemElements = item.elements.split(" ")
                for(element in gemElements){
                    var eButtonName = "elementButton" + element
                    var eResourceId = this.resources.getIdentifier(eButtonName, "id", this.packageName)
                    eButton = findViewById(eResourceId)
                    eButton.setBackgroundColor(Color.BLACK)
                }


                Log.d("GEM", item.name)
            }

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
            R.id.nav_elements -> goToElements()
            R.id.nav_gems -> drawerLayout.close()
            R.id.nav_compounds -> goToCompounds()
        }
        return true
    }

    //Goes to ElementsActivity
    fun goToElements() {
        val i = Intent(this, ElementsActivity::class.java)
        startActivity(i)
    }

    //Goes to CompoundsActivity
    fun goToCompounds() {
        val i = Intent(this, CompoundsActivity::class.java)
        startActivity(i)
    }

}