package com.rishabh.a20220630_rishabharora_nycschools.data.models

import com.squareup.moshi.JsonClass

/**
 *  Data class for NYC School API response
 */
@JsonClass(generateAdapter = true)
data class ErrorJson(
    val message: String
)