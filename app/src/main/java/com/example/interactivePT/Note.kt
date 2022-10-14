package com.example.interactivePT

class Note constructor(text:String) {
    var mText:String
    init{
       mText = text
    }
    fun getText():String{
        return mText
    }
    fun setText(text:String){
        mText = text
    }
}