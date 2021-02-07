package com.shaadi.assigenment.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.shaadi.assigenment.data.model.ResultsItem

@Dao
interface ShaadiDao {

    @Query("SELECT * FROM card")
    fun getAllCards() : LiveData<List<ResultsItem>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(characters: List<ResultsItem>)

    @Query("UPDATE card SET isActionTaken=:isActionTake, actionName=:actionName WHERE email = :email")
     suspend fun updateCard(email: String,isActionTake:Boolean,actionName:String)




}