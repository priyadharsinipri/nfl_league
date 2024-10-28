package com.example.nfl.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.nfl.model.team


@Database(entities = [team ::class],version = 1, exportSchema = false)
 abstract class TeamDatabase:RoomDatabase() {
     abstract fun teamDao(): teamDao

     companion object{

         private var INSTANCE:TeamDatabase? = null

         fun getDatabase(context: Context):TeamDatabase{
             val tempDatabase = INSTANCE
             if(tempDatabase != null){
                 return tempDatabase
             }
             synchronized(this){
                 val instance = Room.databaseBuilder(context.applicationContext,
                     TeamDatabase::class.java,"tea,_database").build()
                 INSTANCE = instance
                 return  instance
             }
         }
     }
}