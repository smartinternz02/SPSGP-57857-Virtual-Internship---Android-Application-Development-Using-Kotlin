package com.example.grocerryapp

//import com.example.grocerylist.Database.Entity.GroceryItems

class GroceryRepository(private val db: GroceryDatabase) {

    suspend fun insert(items: GroceryItems) = db.getGroceryDao().insert(items)
    suspend fun delete(items: GroceryItems) = db.getGroceryDao().delete(items)

    fun allGroceryItems() = db.getGroceryDao().getAllGroceryItems()
}