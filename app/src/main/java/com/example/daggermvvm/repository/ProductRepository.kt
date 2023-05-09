package com.example.daggermvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.daggermvvm.db.FakerDB
import com.example.daggermvvm.models.Product
import com.example.daggermvvm.retrofit.FakerApi
import javax.inject.Inject

class ProductRepository @Inject constructor(private val fakerApi: FakerApi, private val fakerDB:FakerDB){
    private val _products = MutableLiveData<List<Product>>()
    val products:LiveData<List<Product>>
    get() = _products


    suspend fun getProducts(){
        val result = fakerApi.getProducts()
        if(result.isSuccessful && result.body() !=null){
            fakerDB.getFakerDAO().addProducts(result.body()!!)
            _products.postValue(result.body())
        }
    }
}