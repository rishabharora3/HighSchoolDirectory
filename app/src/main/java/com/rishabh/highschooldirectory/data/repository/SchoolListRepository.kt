package com.rishabh.highschooldirectory.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.rishabh.highschooldirectory.data.api.APIService
import com.rishabh.highschooldirectory.data.models.mapper.SchoolListMapper
import com.rishabh.highschooldirectory.data.pagingsources.SchoolListPagingSource
import com.rishabh.highschooldirectory.data.pagingsources.NETWORK_PAGE_SIZE
import com.rishabh.highschooldirectory.ui.models.SchoolListItemResponse

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