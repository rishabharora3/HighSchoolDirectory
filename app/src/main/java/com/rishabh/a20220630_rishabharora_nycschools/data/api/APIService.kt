package com.rishabh.a20220630_rishabharora_nycschools.data.api

import com.rishabh.a20220630_rishabharora_nycschools.data.models.SchoolDetailJson
import com.rishabh.a20220630_rishabharora_nycschools.data.models.SchoolListItemJson
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *  This interface is used to define the API endpoints for the Retrofit library.
 */
interface APIService {
    @GET("s3k6-pzi2.json")
    suspend fun getSchoolList(
        @Query("\$offset") start: Int,
        @Query("\$limit") limit: Int
    ): List<SchoolListItemJson>


    @GET("f9bf-2cp4.json")
    suspend fun getSchoolDetail(
        @Query("dbn") dbn: String
    ): List<SchoolDetailJson>
}