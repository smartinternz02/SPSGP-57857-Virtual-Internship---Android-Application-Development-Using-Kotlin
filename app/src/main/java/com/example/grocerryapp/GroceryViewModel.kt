package com.example.grocerryapp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class GroceryViewModel(private val repository: GroceryRepository) : ViewModel() {

    // In coroutines thread insert item in insert function.
    fun insert(items: GroceryItems) = GlobalScope.launch {
        repository.insert(items)
    }

    // In coroutines thread delete item in delete function.
    fun delete(items: GroceryItems) = GlobalScope.launch {
        repository.delete(items)
    }

    //Here we initialized allGroceryItems function with repository
    fun allGroceryItems() = repository.allGroceryItems()

}