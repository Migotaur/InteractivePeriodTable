package com.example.interactivePT.Repository

import androidx.room.*
import com.example.interactivePT.Repository.Element
import kotlinx.coroutines.flow.Flow

@Dao
interface ElementDao {

    @MapInfo(keyColumn="id")
    @Query("SELECT * FROM element_table order by atomicNumber ASC")
    fun getToDoItems(): Flow<Map<Int, Element>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(toDoItem: Element)

    @Query("DELETE FROM element_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM element_table WHERE atomicNumber = :id")
    suspend fun getItem(id:Int): Element


    @Query("DELETE FROM element_table WHERE atomicNumber=:id")
    suspend fun deleteItem(id: Int)

    @Update
    suspend fun updateItem(element: Element)

}