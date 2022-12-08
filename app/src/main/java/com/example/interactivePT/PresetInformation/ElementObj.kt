package com.example.interactivePT.PresetInformation

class ElementObj(atomicNumber:Int, name:String, symbol:String, atomicMass:Double, meltingPoint:Double, boilingPoint:Double, periodNumber:Int, groupNumber:Int, yearDiscovered:Int, discoverer:String){
    var atomicNumber: Int = atomicNumber
    var name:String = name
    var symbol:String = symbol
    var atomicMass:Double = atomicMass
    var meltingPoint:Double = meltingPoint
    var boilingPoint:Double = boilingPoint
    var periodNumber: Int = periodNumber
    var groupNumber: Int = groupNumber
    var yearDiscovered:Int = yearDiscovered
    var discoveredBy:String = discoverer
    var description:String = ""

    fun addDescription(desc:String){
        this.description = this.name + " was invented in " + this.yearDiscovered + " by " + this.discoveredBy + ". " + desc
    }
}