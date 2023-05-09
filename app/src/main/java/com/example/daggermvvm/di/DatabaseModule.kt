package com.example.daggermvvm.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.daggermvvm.db.FakerDB
import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck
import javax.inject.Singleton


@Module
@DisableInstallInCheck
class DatabaseModule {

    @Singleton
    @Provides
    fun provideFakerDB(context:Context):FakerDB{
        return Room.databaseBuilder(context , FakerDB::class.java,"FakerDB").build()
    }
}