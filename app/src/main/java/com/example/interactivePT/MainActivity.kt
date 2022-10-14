package com.example.interactivePT

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    //Tag for logging errors
    val logtag = "MainActivity"
    //Our Presenter Object
    lateinit var mainActivityPresenter: MainActivityPresenter
    //Our View Object
    lateinit var mainActivityFragment: MainActivityView
    //Our Model Object
    lateinit var mainActivityModel:MainActivityModel

    /**
     * onCreate -- Overrides the super onCreate method
     * sets the view to R.layout.activity main
     * finds and sets the View object to the reference of the fragment created by the fragment container view
     * Creates the model (eventually replace with get a reference to the model)
     * Creates the presenter, giving it a reference to the model
     * Sets the view for the presenter to the fragment
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(logtag,"onCreate called")
        setContentView(R.layout.activity_main)
        mainActivityFragment = (getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView) as MainActivityView?)!!
        mainActivityModel = MainActivityModel()
        mainActivityPresenter = MainActivityPresenter(mainActivityModel)
        mainActivityPresenter.setView(mainActivityFragment)
    }

    override fun onResume() {
        super.onResume()
        Log.d(logtag,"onResume called")
    }

    override fun onStart() {
        super.onStart()
        Log.d(logtag,"onStart called")
    }
}