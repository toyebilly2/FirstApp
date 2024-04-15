package com.rebeka.firstapp.service.repository.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rebeka.firstapp.service.model.Pessoa

@Database(entities = [Pessoa::class], version = 1)
abstract class FirstAppDataBase: RoomDatabase() {

    abstract fun pessoaDAO(): PessoaDAO

    companion object{
        @Volatile
        private lateinit var INSTANCE: FirstAppDataBase

        fun getDataBase(context: Context): FirstAppDataBase{
            if (!Companion::INSTANCE.isInitialized) {
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context, FirstAppDataBase::class.java, "firstapp_database").build()
                }
            }

            return INSTANCE
        }
    }
}