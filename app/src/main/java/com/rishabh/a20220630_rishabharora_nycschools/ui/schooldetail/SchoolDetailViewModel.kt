package com.rishabh.a20220630_rishabharora_nycschools.ui.schooldetail

import androidx.lifecycle.LiveData
import com.rishabh.a20220630_rishabharora_nycschools.data.repository.SchoolDetailRepository
import com.rishabh.a20220630_rishabharora_nycschools.ui.base.BaseViewModel
import com.rishabh.a20220630_rishabharora_nycschools.ui.models.SchoolDetailResponse
import com.rishabh.a20220630_rishabharora_nycschools.util.Resource

/**
 *  ViewModel for SchoolDetailFragment
 */
class SchoolDetailViewModel(private val repository: SchoolDetailRepository) : BaseViewModel() {

    suspend fun getSchoolDetail(schoolId: String): LiveData<Resource<List<SchoolDetailResponse>>> {
        return repository.getSchoolDetail(schoolId)
    }
}