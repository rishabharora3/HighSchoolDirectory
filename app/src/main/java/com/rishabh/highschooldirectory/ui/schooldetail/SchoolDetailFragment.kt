package com.rishabh.highschooldirectory.ui.schooldetail

import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.rishabh.highschooldirectory.R
import com.rishabh.highschooldirectory.databinding.FragmentSchoolDetailBinding
import com.rishabh.highschooldirectory.ui.base.BaseFragment
import com.rishabh.highschooldirectory.util.Status
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

/**
 *  Fragment to display school details
 */
class SchoolDetailFragment : BaseFragment<FragmentSchoolDetailBinding, SchoolDetailViewModel>() {

    override val viewModel: SchoolDetailViewModel by viewModel()

    override fun layout(): Int = R.layout.fragment_school_detail

    override fun init() {
        initView()
        initObservers()
        bindEvents()
    }

    /**
     *  add listeners to views
     */
    private fun bindEvents() {
        with(binding) {
            // swipe to refresh
            refreshLayout.setOnRefreshListener {
                initObservers()
            }

            btnRetry.setOnClickListener {
                initObservers()
            }
        }
    }

    /**
     * observe the view model
     */
    private fun initObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            val schoolId = arguments?.getString("schoolId") ?: ""
            viewModel.getSchoolDetail(schoolId).observe(viewLifecycleOwner) {
                when (it.status) {
                    Status.LOADING -> {
                        binding.refreshLayout.isRefreshing = true
                    }

                    Status.ERROR -> {
                        binding.refreshLayout.isRefreshing = false
                        binding.tvNoResults.isVisible = true
                        showToastMessage("Something went wrong")
                    }

                    Status.SUCCESS -> {
                        binding.refreshLayout.isRefreshing = false
                        if (it.data?.isNotEmpty() == true) {
                            binding.schoolDetail = it.data[0]
                        } else {
                            binding.tvNoResults.isVisible = true
                        }
                    }
                }
            }
        }
    }


    /**
     * Initialize the view
     */
    private fun initView() {
        setHasOptionsMenu(true)
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowTitleEnabled(true)
    }
}