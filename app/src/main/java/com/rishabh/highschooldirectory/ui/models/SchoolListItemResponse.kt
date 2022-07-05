package com.rishabh.highschooldirectory.ui.models

/**
 * Data class for NYC Schools API response
 */
data class SchoolListItemResponse(
    val dbn: String,
    val school_name: String,
    val location: String,
    val phone_number: String,
    val school_email: String,
    val website: String,
)