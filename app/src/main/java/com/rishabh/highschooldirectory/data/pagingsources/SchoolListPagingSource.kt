package com.rishabh.highschooldirectory.data.pagingsources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.rishabh.highschooldirectory.data.api.APIService
import com.rishabh.highschooldirectory.data.models.mapper.SchoolListMapper
import com.rishabh.highschooldirectory.ui.models.SchoolListItemResponse

const val NETWORK_PAGE_SIZE = 20 // how many items to load at once
private const val INITIAL_LOAD_SIZE = 1 // initial load size

/**
 * PagingSource for school list
 */
class SchoolListPagingSource(
    private val service: APIService,
    private val mapper: SchoolListMapper
) : PagingSource<Int, SchoolListItemResponse>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SchoolListItemResponse> {
        // Load data from network
        val position = params.key ?: INITIAL_LOAD_SIZE
        val offset = if (params.key != null) ((position - 1) * NETWORK_PAGE_SIZE) + 1 else INITIAL_LOAD_SIZE
        return try {
            val jsonResponse = service.getSchoolList(start = offset, limit = params.loadSize)
            val response = mapper.toSchoolListResponse(jsonResponse)
            val nextKey = if (response.isEmpty()) {
                null
            } else {
                // Load next page if there are more schools to load
                // If there are no more schools to load, null will be returned
                position + (params.loadSize / NETWORK_PAGE_SIZE)
            }
            LoadResult.Page(
                data = response,
                prevKey = null, // No previous page
                // If there are no more schools to load, null will be returned
                nextKey = nextKey
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, SchoolListItemResponse>): Int? {
        // Return the refresh key if there is one
        // This is used to determine if the data is stale and needs to be refreshed
        return null
    }
}