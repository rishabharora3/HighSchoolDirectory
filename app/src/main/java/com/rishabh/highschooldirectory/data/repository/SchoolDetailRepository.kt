package com.rishabh.highschooldirectory.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rishabh.highschooldirectory.data.api.APIService
import com.rishabh.highschooldirectory.data.models.mapper.SchoolDetailMapper
import com.rishabh.highschooldirectory.ui.models.SchoolDetailResponse
import com.rishabh.highschooldirectory.util.Resource

/**
 * Repository class for handling the data fetching and processing logic
 */
interface SchoolDetailRepository {
    suspend fun getSchoolDetail(schoolId: String): LiveData<Resource<List<SchoolDetailResponse>>>
}

class SchoolDetailRepositoryImpl(
    private val service: APIService,
    private val mapper: SchoolDetailMapper
) : SchoolDetailRepository {

    /**
     * Method to fetch the school details from the API
     */
    override suspend fun getSchoolDetail(schoolId: String): LiveData<Resource<List<SchoolDetailResponse>>> {
        val liveData = MutableLiveData<Resource<List<SchoolDetailResponse>>>()
        try {
            liveData.postValue(Resource.loading())
            val jsonResponse = service.getSchoolDetail(dbn = schoolId)
            val response = mapper.toSchoolDetailResponse(jsonResponse)
            liveData.postValue(Resource.success(response))
        } catch (e: Exception) {
            liveData.postValue(Resource.error())
        }
        return liveData
    }
}

