package com.rishabh.highschooldirectory.data.providers

import com.rishabh.highschooldirectory.BuildConfig
import com.rishabh.highschooldirectory.data.models.ApiException
import com.rishabh.highschooldirectory.data.models.ErrorJson
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 *  This class is used to create a retrofit instance for the API
 */

class RetrofitProvider(
    private val moshi: Moshi, // Moshi instance used to convert the JSON to POJOs
    private val apiUrl: String
) {
    /**
     * This method is used to create a retrofit instance for the API
     */
    fun provide(): Retrofit {
        val client = OkHttpClient.Builder()
            .handleErrors()
            .setLogger(HttpLoggingInterceptor.Level.BODY)
            .setApiKey()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .client(client)
            .setConverters()
            .baseUrl(apiUrl)
            .build()
    }

    /**
     * This method is used to set the API key in the header of the request
     */
    private fun Retrofit.Builder.setConverters() =
        addConverterFactory(MoshiConverterFactory.create(moshi))

    /**
     * This method is used to set the API key in the header of the request
     */
    private fun OkHttpClient.Builder.setLogger(
        logLevel: HttpLoggingInterceptor.Level
    ): OkHttpClient.Builder {
        if (BuildConfig.DEBUG) {
            addInterceptor(HttpLoggingInterceptor().apply {
                level = logLevel
            })
        }
        return this
    }

    /**
     * This method is used to set the API key in the header of the request
     */
    private fun OkHttpClient.Builder.setApiKey() = addInterceptor { chain ->
        val request = chain.request().newBuilder()
            .header("Accept", "application/json")
            .addHeader("X-App-Token", BuildConfig.API_KEY)
        chain.proceed(request.build())
    }

    /**
     * This method is used to handle the error response from the API
     */
    private fun OkHttpClient.Builder.handleErrors() = addInterceptor { chain ->
        val response = chain.proceed(chain.request())

        if (response.isSuccessful) {
            response
        } else {
            val code = response.code
            val body = response.body

            throw if (body == null) {
                ApiException("Server response is empty")
            } else {
                try {
                    val error =
                        moshi.adapter(ErrorJson::class.java).fromJson(body.string())?.message
                    ApiException(error)
                } catch (ex: Exception) {
                    ApiException("Cannot parse error: ${ex.message}")
                } finally {
                    body.close()
                }
            }
        }
    }
}