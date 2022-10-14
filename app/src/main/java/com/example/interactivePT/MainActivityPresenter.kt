package com.example.interactivePT

class MainActivityPresenter(mainActivityModel: MainActivityModel) :MainActivityContract.Presenter{
    lateinit var mView:MainActivityContract.View
    lateinit var mModel:MainActivityModel

    init {
        mModel = mainActivityModel
    }

    override fun setView(view: MainActivityContract.View) {
        mView = view
        mView.setPresenter(this)

    }

    override fun start() {
        mModel.setNote(Note("Interactive Periodic Table"))
        mView.setTextView(mModel.getNote().getText())
    }

    override fun buttonClicked() {
        mModel.menuToggle = !mModel.menuToggle

        if(mModel.menuToggle){
            mModel.getNote().setText("Menu Opened!")
        }else{
            mModel.getNote().setText("Interactive Periodic Table!")
        }
        mView.updateView()
    }

    override fun getNoteText():String {
        return mModel.getNote().getText()
    }
}