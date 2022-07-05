package com.rishabh.highschooldirectory.data.models

import com.squareup.moshi.JsonClass

/**
 *  Data class for NYC School API response
 */
@JsonClass(generateAdapter = true)
data class ErrorJson(
    val message: String
)