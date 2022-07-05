package com.rishabh.a20220630_rishabharora_nycschools.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Data class to hold the school data
 */
@JsonClass(generateAdapter = true)
data class SchoolDetailJson(
    @Json(name = "dbn")
    var dbn: String? = null,

    @Json(name = "school_name")
    var school_name: String? = null,

    @Json(name = "num_of_sat_test_takers")
    var num_of_sat_test_takers: String? = null,

    @Json(name = "sat_critical_reading_avg_score")
    var sat_critical_reading_avg_score: String? = null,

    @Json(name = "sat_math_avg_score")
    var sat_math_avg_score: String? = null,

    @Json(name = "sat_writing_avg_score")
    var sat_writing_avg_score: String? = null
)