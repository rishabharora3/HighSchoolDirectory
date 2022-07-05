package com.rishabh.a20220630_rishabharora_nycschools.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.IOException

/**
 *  Data class for NYC School API response
 */
@JsonClass(generateAdapter = true)
data class ApiExceptionBody(
    @Json(name = "error_code") val errorCode: Int,
    @Json(name = "error_message") val errorMessage: String
)

data class ApiException(
    val errorMessage: String?
) : IOException("$errorMessage")
