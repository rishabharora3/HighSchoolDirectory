package com.rishabh.highschooldirectory.ui.schooldetail

import androidx.lifecycle.LiveData
import com.rishabh.highschooldirectory.data.repository.SchoolDetailRepository
import com.rishabh.highschooldirectory.ui.base.BaseViewModel
import com.rishabh.highschooldirectory.ui.models.SchoolDetailResponse
import com.rishabh.highschooldirectory.util.Resource

/**
 *  ViewModel for SchoolDetailFragment
 */
class SchoolDetailViewModel(private val repository: SchoolDetailRepository) : BaseViewModel() {

    suspend fun getSchoolDetail(schoolId: String): LiveData<Resource<List<SchoolDetailResponse>>> {
        return repository.getSchoolDetail(schoolId)
    }
}