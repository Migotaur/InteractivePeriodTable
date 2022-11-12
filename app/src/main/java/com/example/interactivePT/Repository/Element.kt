package com.example.interactivePT.Repository

import androidx.room.ColumnInfo
import androidx.room.DatabaseConfiguration
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "element_table")
data class Element(
    @PrimaryKey(autoGenerate = true) var atomicNumber: Int,
    @ColumnInfo(name = "name") var name:String,
    @ColumnInfo(name = "symbol") var symbol:String,
    @ColumnInfo(name="atomicMass") var atomicMass:Double,
    @ColumnInfo(name="boilingPoint") var meltingPoint:Double,
    @ColumnInfo(name="boilingPoint") var boilingPoint:Double,
    @ColumnInfo(name = "periodNumber") var periodNumber: Int,
    @ColumnInfo(name = "groupNumber") var groupNumber: Int,
    @ColumnInfo(name="yearDiscovered") var yearDiscovered:Int,
    @ColumnInfo(name="discoveredBy") var discoveredBy:String
)
