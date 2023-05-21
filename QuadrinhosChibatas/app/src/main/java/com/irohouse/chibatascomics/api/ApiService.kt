package com.irohouse.chibatascomics.api

import android.util.Log
import com.irohouse.chibatascomics.util.Constants.MarvelApi.BASE_URL
import com.irohouse.chibatascomics.util.Constants.MarvelApi.PRIVATE_KEY
import com.irohouse.chibatascomics.util.Constants.MarvelApi.PUBLIC_KEY
import com.irohouse.chibatascomics.util.MarvelHashGenerator
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiService {

    val marvelApi: MarvelApi = getMarvelApi().create(MarvelApi::class.java)

    fun getMarvelApi() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(getClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val interceptor = OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .addInterceptor(getAuthorizationInterceptor())
        return interceptor.build()
    }

    private fun getAuthorizationInterceptor(): Interceptor {
        return Interceptor { chain ->
            val ts = System.currentTimeMillis().toString()
            val hash = MarvelHashGenerator.get(ts)
            val url = chain.request()
                .url
                .newBuilder()
                .addQueryParameter("ts", ts)
                .addQueryParameter("apikey", PUBLIC_KEY)
                .addQueryParameter("hash", hash)
                .build()
            Log.i("URL INTERCEPTOR", "getAuthorizationInterceptor: $url")
            val request = chain.request()
                .newBuilder()
                .url(url)
                .build()
            return@Interceptor chain.proceed(request)
        }
    }

}