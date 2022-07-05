package com.rishabh.a20220630_rishabharora_nycschools.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Data class to hold the school data
 */
@JsonClass(generateAdapter = true)
data class SchoolListItemJson(
    @Json(name = "dbn")
    var dbn: String? = null,

    @Json(name = "school_name")
    var school_name: String? = null,

    @Json(name = "boro")
    var boro: String? = null,

    @Json(name = "overview_paragraph")
    var overview_paragraph: String? = null,

    @Json(name = "school_10th_seats")
    var school_10th_seats: String? = null,

    @Json(name = "academicopportunities1")
    var academicopportunities1: String? = null,

    @Json(name = "academicopportunities2")
    var academicopportunities2: String? = null,

    @Json(name = "ell_programs")
    var ell_programs: String? = null,

    @Json(name = "neighborhood")
    var neighborhood: String? = null,

    @Json(name = "building_code")
    var building_code: String? = null,

    @Json(name = "location")
    var location: String? = null,

    @Json(name = "phone_number")
    var phone_number: String? = null,

    @Json(name = "fax_number")
    var fax_number: String? = null,

    @Json(name = "school_email")
    var school_email: String? = null,

    @Json(name = "website")
    var website: String? = null,

    @Json(name = "subway")
    var subway: String? = null,

    @Json(name = "bus")
    var bus: String? = null,

    @Json(name = "grades2018")
    var grades2018: String? = null,

    @Json(name = "finalgrades")
    var finalgrades: String? = null,

    @Json(name = "total_students")
    var total_students: String? = null,

    @Json(name = "extracurricular_activities")
    var extracurricular_activities: String? = null,

    @Json(name = "school_sports")
    var school_sports: String? = null,

    @Json(name = "attendance_rate")
    var attendance_rate: String? = null,

    @Json(name = "pct_stu_enough_variety")
    var pct_stu_enough_variety: String? = null,

    @Json(name = "pct_stu_safe")
    var pct_stu_safe: String? = null,

    @Json(name = "school_accessibility_description")
    var school_accessibility_description: String? = null,

    @Json(name = "directions1")
    var directions1: String? = null,

    @Json(name = "requirement1_1")
    var requirement1_1: String? = null,

    @Json(name = "requirement2_1")
    var requirement2_1: String? = null,

    @Json(name = "requirement3_1")
    var requirement3_1: String? = null,

    @Json(name = "requirement4_1")
    var requirement4_1: String? = null,

    @Json(name = "requirement5_1")
    var requirement5_1: String? = null,

    @Json(name = "offer_rate1")
    var offer_rate1: String? = null,

    @Json(name = "program1")
    var program1: String? = null,

    @Json(name = "code1")
    var code1: String? = null,

    @Json(name = "interest1")
    var interest1: String? = null,

    @Json(name = "method1")
    var method1: String? = null,

    @Json(name = "seats9ge1")
    var seats9ge1: String? = null,

    @Json(name = "grade9gefilledflag1")
    var grade9gefilledflag1: String? = null,

    @Json(name = "grade9geapplicants1")
    var grade9geapplicants1: String? = null,

    @Json(name = "seats9swd1")
    var seats9swd1: String? = null,

    @Json(name = "grade9swdfilledflag1")
    var grade9swdfilledflag1: String? = null,

    @Json(name = "grade9swdapplicants1")
    var grade9swdapplicants1: String? = null,

    @Json(name = "seats101")
    var seats101: String? = null,

    @Json(name = "admissionspriority11")
    var admissionspriority11: String? = null,

    @Json(name = "admissionspriority21")
    var admissionspriority21: String? = null,

    @Json(name = "admissionspriority31")
    var admissionspriority31: String? = null,

    @Json(name = "grade9geapplicantsperseat1")
    var grade9geapplicantsperseat1: String? = null,

    @Json(name = "grade9swdapplicantsperseat1")
    var grade9swdapplicantsperseat1: String? = null,

    @Json(name = "primary_address_line_1")
    var primary_address_line_1: String? = null,

    @Json(name = "city")
    var city: String? = null,

    @Json(name = "zip")
    var zip: String? = null,

    @Json(name = "state_code")
    var state_code: String? = null,

    @Json(name = "latitude")
    var latitude: String? = null,

    @Json(name = "longitude")
    var longitude: String? = null,

    @Json(name = "community_board")
    var community_board: String? = null,

    @Json(name = "council_district")
    var council_district: String? = null,

    @Json(name = "census_tract")
    var census_tract: String? = null,

    @Json(name = "bin")
    var bin: String? = null,

    @Json(name = "bbl")
    var bbl: String? = null,

    @Json(name = "nta")
    var nta: String? = null,

    @Json(name = "borough")
    var borough: String? = null,

    @Json(name = "academicopportunities3")
    var academicopportunities3: String? = null,

    @Json(name = "language_classes")
    var language_classes: String? = null,

    @Json(name = "addtl_info1")
    var addtl_info1: String? = null,

    @Json(name = "transfer")
    var transfer: String? = null,

    @Json(name = "eligibility1")
    var eligibility1: String? = null,

    @Json(name = "academicopportunities4")
    var academicopportunities4: String? = null,

    @Json(name = "academicopportunities5")
    var academicopportunities5: String? = null,

    @Json(name = "diplomaendorsements")
    var diplomaendorsements: String? = null,

    @Json(name = "shared_space")
    var shared_space: String? = null,

    @Json(name = "start_time")
    var start_time: String? = null,

    @Json(name = "end_time")
    var end_time: String? = null,

    @Json(name = "psal_sports_boys")
    var psal_sports_boys: String? = null,

    @Json(name = "psal_sports_girls")
    var psal_sports_girls: String? = null,

    @Json(name = "psal_sports_coed")
    var psal_sports_coed: String? = null,

    @Json(name = "graduation_rate")
    var graduation_rate: String? = null,

    @Json(name = "college_career_rate")
    var college_career_rate: String? = null,

    @Json(name = "girls")
    var girls: String? = null,

    @Json(name = "advancedplacement_courses")
    var advancedplacement_courses: String? = null,

    @Json(name = "campus_name")
    var campus_name: String? = null,

    @Json(name = "prgdesc1")
    var prgdesc1: String? = null,

    @Json(name = "admissionspriority41")
    var admissionspriority41: String? = null
)