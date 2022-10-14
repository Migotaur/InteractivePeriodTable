package com.example.interactivePT

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


/**
 * A simple [Fragment] subclass.
 * Use the [MainActivityView.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainActivityView : Fragment(),MainActivityContract.View {
    //Presenter object, as lateinit because it shouldn't be null
    lateinit var mPresenter:MainActivityContract.Presenter
    //textView object, as lateinit because it is null until it is created, then shouldn't be null
    lateinit var textView:TextView
    lateinit var btnChange:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //get reference to the fragment view object
        val view = inflater.inflate(R.layout.fragment_main_activity_view, container, false)
        //find any objects in the view (text view for now)
        textView = view.findViewById(R.id.tvPlaceholder)
        btnChange = view.findViewById(R.id.btnChangeText)
        btnChange.setOnClickListener { mPresenter.buttonClicked() }
        //return the view object
        return view
    }

    override fun onResume() {
        super.onResume()
        //Start the presenter here, once all objects have been created
        mPresenter.start()
    }

    companion object{
        //Companion object to create a new instance of the view object
        fun newInstance():MainActivityView{
            val mainActivityView:MainActivityView = MainActivityView()
            return mainActivityView
        }
    }


    //Contract function to set the view from the Presenter
    override fun setTextView(text:String){
        textView.setText(text)
    }

    override fun updateView() {
        textView.setText(mPresenter.getNoteText())

    }

    //Initialize contract function to give a reference to the presenter from the view
    override fun setPresenter(presenter: MainActivityContract.Presenter) {
        mPresenter = presenter
    }
}