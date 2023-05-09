package com.example.daggermvvm.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.daggermvvm.models.Product

@Dao
interface  FakerDao {
    @Insert
    suspend fun addProducts(product: List<Product>)

    @Query("SELECT * FROM PRODUCT")
    suspend fun getProducts():List<Product>
}