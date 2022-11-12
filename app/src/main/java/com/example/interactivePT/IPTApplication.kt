package com.example.interactivePT

import android.app.Application
import com.example.interactivePT.Repository.ElementRepository
import com.example.interactivePT.Repository.ElementDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class IPTApplication: Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { ElementDatabase.getDatabase(this,applicationScope)}
    val repository by lazy{ ElementRepository(database.elementDao()) }
}