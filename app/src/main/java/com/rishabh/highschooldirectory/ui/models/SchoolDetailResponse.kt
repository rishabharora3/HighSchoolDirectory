package com.rishabh.highschooldirectory.ui.models

/**
 * Data class for NYC Schools API response
 */
data class SchoolDetailResponse(
    val school_name: String,
    val sat_critical_reading_avg_score: String,
    val sat_math_avg_score: String,
    val sat_writing_avg_score: String,

    val school_name_tag: String = "School Name",
    val sat_critical_reading_avg_score_tag: String = "Critical Reading Avg Score",
    val sat_math_avg_score_tag: String = "Math Avg Score",
    val sat_writing_avg_score_tag: String = "Writing Avg Score"

)