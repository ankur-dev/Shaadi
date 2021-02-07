package com.shaadi.assigenment.data.remote

import com.shaadi.assigenment.data.network.ApiService

class RemoteDataSource  constructor(
    private val apiService: ApiService
): BaseDataSource() {

    suspend fun getAllRecordsFromServer(count:Int) = getResult { apiService.getShaadiItemRecords(count) }
}