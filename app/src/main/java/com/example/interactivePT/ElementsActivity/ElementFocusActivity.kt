package com.example.interactivePT.ElementsActivity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.example.interactivePT.ElementsActivity.ElementsActivity
import com.example.interactivePT.PresetInformation.PresetInformation
import com.example.interactivePT.R
import com.google.android.material.navigation.NavigationView


class ElementFocusActivity : AppCompatActivity() {

    lateinit var backButton: Button
    lateinit var symbol_text: TextView
    lateinit var name_text: TextView
    lateinit var atomNumber_text: TextView
    lateinit var atomMass_text: TextView
    lateinit var points_text: TextView
    lateinit var info_text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.efocus_activity)
        backButton = findViewById(R.id.back_button)
        symbol_text = findViewById(R.id.element_symbol)
        name_text = findViewById(R.id.element_name)
        atomMass_text = findViewById(R.id.element_atomMass)
        atomNumber_text = findViewById(R.id.element_atomicnumber)
        points_text = findViewById(R.id.element_points)
        info_text = findViewById(R.id.element_info)
        backButton.setOnClickListener {
            setResult(RESULT_OK)
            finish()
        }

        //Get Intents
        val symbol = intent.getStringExtra(ElementsActivity.INFORMATION)
        val name = intent.getStringExtra(ElementsActivity.DISCOVERER)
        val description = intent.getStringExtra(ElementsActivity.Desc)

        if (symbol != null){
            val infoList = symbol.split(" ")
            symbol_text.setText(infoList[0])
            name_text.setText(infoList[1])
            atomNumber_text.setText(infoList[2])
            atomMass_text.setText(infoList[3])
            points_text.setText("Melting Point: " + infoList[4] + " C\n\n Boiling Point: " + infoList[5] + " C")
            info_text.setText(description)
        }

    }

}