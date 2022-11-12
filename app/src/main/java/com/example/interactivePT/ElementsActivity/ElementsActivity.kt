package com.example.interactivePT.ElementsActivity

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.interactivePT.PresetInformation.PresetInformation
import com.example.interactivePT.R
import com.google.android.material.internal.NavigationMenu
import com.google.android.material.navigation.NavigationView





class ElementsActivity : AppCompatActivity() {
    private val presetInformation = PresetInformation()
    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

//    val startAddEditToDoActivity = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
//            result: ActivityResult ->
//        if(result.resultCode== Activity.RESULT_OK){
//            Log.d("MainActivity","Completed")
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.elements_activity)

        drawerLayout = findViewById(R.id.my_drawer_layout)
        //navigationView = findViewById(R.id.my_nav_view)
        actionBarDrawerToggle =
            ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)
        val allElements = presetInformation.getElements()
        for (element in allElements) {
            Log.d("ELEMENTS", element.toString())
        }

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            Log.d("MENU", item.toString())
            true
        } else super.onOptionsItemSelected(item)
    }

}