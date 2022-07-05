package com.rishabh.a20220630_rishabharora_nycschools.data.models.mapper

import com.rishabh.a20220630_rishabharora_nycschools.data.models.SchoolDetailJson
import com.rishabh.a20220630_rishabharora_nycschools.ui.models.SchoolDetailResponse

/**
 * Mapper class to map SchoolDetailJson to SchoolDetailResponse
 */
class SchoolDetailMapper {

    fun toSchoolDetailResponse(json: List<SchoolDetailJson>?): List<SchoolDetailResponse> {
        with(json) {
            return if (this?.isNotEmpty() == true) {
                this.map { toSchoolDetailItemResponse(it) }
            } else {
                emptyList()
            }
        }
    }

    private fun toSchoolDetailItemResponse(json: SchoolDetailJson): SchoolDetailResponse {
        with(json) {
            return SchoolDetailResponse(
                school_name = school_name ?: "",
                sat_critical_reading_avg_score = sat_critical_reading_avg_score ?: "",
                sat_math_avg_score = sat_math_avg_score ?: "",
                sat_writing_avg_score = sat_writing_avg_score ?: "",
            )
        }
    }
}