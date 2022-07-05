package com.rishabh.a20220630_rishabharora_nycschools.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.rishabh.a20220630_rishabharora_nycschools.data.api.APIService
import com.rishabh.a20220630_rishabharora_nycschools.data.models.mapper.SchoolListMapper
import com.rishabh.a20220630_rishabharora_nycschools.data.pagingsources.SchoolListPagingSource
import com.rishabh.a20220630_rishabharora_nycschools.data.pagingsources.NETWORK_PAGE_SIZE
import com.rishabh.a20220630_rishabharora_nycschools.ui.models.SchoolListItemResponse

/**
 * Repository class for handling data operations.
 */
interface SchoolListRepository {
    suspend fun getSchoolList(): LiveData<PagingData<SchoolListItemResponse>>
}

/**
 * Repository class for handling data operations.
 */
class SchoolRepositoryImpl(
    private val service: APIService,
    private val mapper: SchoolListMapper
) : SchoolListRepository {
    override suspend fun getSchoolList(): LiveData<PagingData<SchoolListItemResponse>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                SchoolListPagingSource(service, mapper)
            }
        ).liveData
    }
}