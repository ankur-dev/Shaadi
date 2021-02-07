package com.shaadi.assigenment.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.shaadi.assigenment.BuildConfig
import com.shaadi.assigenment.data.local.AppDatabase
import com.shaadi.assigenment.data.local.ShaadiDao
import com.shaadi.assigenment.data.network.ApiService
import com.shaadi.assigenment.data.network.NetworkHelper
import com.shaadi.assigenment.data.remote.RemoteDataSource
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val appModule = module {
    single { provideOkHttpClient() }
    single { provideApiService(get(),get()) }
    single { provideNetworkHelper(get()) }
    single { provideDatabase(get())}
    single { provideRemoteDataSource(get()) }
    single { provideDao(get()) }
    single { provideGson() }
}

/*
* Data base provider
* */
fun provideDatabase(context: Context): AppDatabase = AppDatabase.getDatabase(context)


/* Dao Provider */
fun provideDao(db: AppDatabase): ShaadiDao = db.getShaadiDao()

/*
* Data base provider
* */
fun provideRemoteDataSource(apiService: ApiService): RemoteDataSource = RemoteDataSource(apiService)

fun provideGson(): Gson = GsonBuilder().create()


private fun provideNetworkHelper(context: Context) = NetworkHelper(context)

/**
 * Create Provider for OkHttp Client
 * if app is in debug mode then api response will not log in logcate
 */
private fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .readTimeout(15, TimeUnit.SECONDS).
        connectTimeout(15, TimeUnit.SECONDS)
        .build()
} else {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.level = HttpLoggingInterceptor.Level.NONE

    OkHttpClient
        .Builder().addInterceptor(loggingInterceptor).readTimeout(20, TimeUnit.SECONDS)
        .connectTimeout(20, TimeUnit.SECONDS)
        .build()
}

/**
 * Create Provider for Rest Clint
 * this taking one parameter
 * @param okHttpClient OkHtpp clint
 */
private fun provideApiService(
    okHttpClient: OkHttpClient,gson: Gson
): ApiService =
    Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
     //   .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .build().create(ApiService::class.java)


