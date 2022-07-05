package com.rishabh.a20220630_rishabharora_nycschools.data.models.mapper

import com.rishabh.a20220630_rishabharora_nycschools.data.models.SchoolListItemJson
import com.rishabh.a20220630_rishabharora_nycschools.ui.models.SchoolListItemResponse

/**
 * Mapper class to map SchoolListItemJson to SchoolListItemResponse
 */

class SchoolListMapper {

    fun toSchoolListResponse(json: List<SchoolListItemJson>?): List<SchoolListItemResponse> {
        with(json) {
            return if (this?.isNotEmpty() == true) {
                this.map { toSchoolItemResponse(it) }
            } else {
                emptyList()
            }
        }
    }

    private fun toSchoolItemResponse(json: SchoolListItemJson): SchoolListItemResponse {
        with(json) {
            return SchoolListItemResponse(
                dbn = dbn?: "",
                school_name = school_name?: "",
                phone_number = phone_number?: "",
                school_email = school_email?: "",
                location = location?: "",
                website = website?: "",
            )
        }
    }
}