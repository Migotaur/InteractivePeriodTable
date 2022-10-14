package com.example.interactivePT

class MainActivityModel {

    lateinit var mNote: Note
    var menuToggle: Boolean = false
    fun setNote(note: Note){
        mNote = note
    }

    fun getNote():Note{
        return mNote
    }

    fun toggleNote(){
        menuToggle = !menuToggle
    }

}