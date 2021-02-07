package com.shaadi.assigenment.data.repository

import com.shaadi.assigenment.data.local.ShaadiDao
import com.shaadi.assigenment.data.remote.RemoteDataSource
import com.shaadi.assigenment.util.performGetOperation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MatchCardRepository constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: ShaadiDao
) {

    fun getAllCards(count:Int) = performGetOperation(
        databaseQuery = { localDataSource.getAllCards() },
        networkCall = { remoteDataSource.getAllRecordsFromServer(count) },
        saveCallResult = { localDataSource.insertAll(it.results) }
    )


    fun updateData(actionName:String,email:String){
        CoroutineScope(Dispatchers.IO).launch {
         localDataSource.updateCard(email,true,actionName)

        }
    }


}