package com.example.interactivePT.ElementsActivity

import androidx.lifecycle.*
import com.example.interactivePT.Repository.ElementRepository


class ElementsViewModel(private val repository: ElementRepository): ViewModel() {
    val allElements = repository.allPreset

    class ElementViewModelFactory(private val repository: ElementRepository) : ViewModelProvider.Factory{
        override fun <T: ViewModel> create(modelClass: Class<T>): T{
            if(modelClass.isAssignableFrom(ElementsViewModel::class.java)){
                @Suppress("UNCHECKED_CAST")
                return ElementsViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel Class")
        }
    }


}