package com.rishabh.highschooldirectory.ui.schoollist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.rishabh.highschooldirectory.data.repository.SchoolListRepository
import com.rishabh.highschooldirectory.ui.base.BaseViewModel
import com.rishabh.highschooldirectory.ui.models.SchoolListItemResponse

/**
 * ViewModel for SchoolListFragment
 */
class SchoolListViewModel(private val repository: SchoolListRepository) : BaseViewModel() {

    private val _schoolList = MutableLiveData<PagingData<SchoolListItemResponse>>()

    suspend fun getSchoolList(): LiveData<PagingData<SchoolListItemResponse>> {
        val response = repository.getSchoolList().cachedIn(viewModelScope)
        _schoolList.value = response.value
        return response
    }
}