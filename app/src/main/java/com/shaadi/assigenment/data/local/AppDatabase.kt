package com.shaadi.assigenment.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shaadi.assigenment.data.model.ResultsItem

@Database(entities = [ResultsItem::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getShaadiDao(): ShaadiDao

    companion object {
        @Volatile private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) { instance ?: buildDatabase(context).also { instance = it } }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, AppDatabase::class.java, "shaadi")
                .fallbackToDestructiveMigration()
                .build()
    }

}