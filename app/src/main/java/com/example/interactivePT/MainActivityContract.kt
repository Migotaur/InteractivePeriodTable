package com.example.interactivePT

interface MainActivityContract {
    interface View{
        fun setPresenter(presenter:MainActivityContract.Presenter)
        fun setTextView(text:String)
        fun updateView()
    }

    interface Presenter{
        fun setView(view:MainActivityContract.View)
        fun start()
        fun buttonClicked()
        fun getNoteText():String
    }
}