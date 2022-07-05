package com.rishabh.a20220630_rishabharora_nycschools.ui.schoollist

import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rishabh.a20220630_rishabharora_nycschools.R
import com.rishabh.a20220630_rishabharora_nycschools.databinding.FragmentSchoolListBinding
import com.rishabh.a20220630_rishabharora_nycschools.ui.base.BaseFragment
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * A fragment representing a list of Items.
 */
class SchoolListFragment : BaseFragment<FragmentSchoolListBinding, SchoolListViewModel>() {

    companion object {
        private const val START_POSITION = 0
    }

    private val schoolListAdapter by lazy {
        SchoolListAdapter {
//            showToastMessage(getString(R.string.item_clicked, it.school_name))
            val bundle = bundleOf("schoolId" to it.dbn)
            Navigation.findNavController(binding.root).navigate(
                R.id.action_schoolListFragment_to_schoolDetailFragment,
                bundle
            )
        }
    }

    private val itemDecorator by lazy {
        SchoolListMarginDecoration(
            requireContext(),
            R.dimen.spacing_small
        )
    }

    override val viewModel: SchoolListViewModel by viewModel()

    override fun layout(): Int = R.layout.fragment_school_list

    override fun init() {
        initView()
        initObservers()
        initAdapter()
        bindEvents()
    }

    private fun initView() {
        // initial toolbar
        setHasOptionsMenu(true)
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowTitleEnabled(true)

        // initial recyclerView
        binding.rcSchoolList.addItemDecoration(itemDecorator)
        binding.rcSchoolList.adapter = schoolListAdapter
    }

    private fun initObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getSchoolList().observe(viewLifecycleOwner) {
                schoolListAdapter.submitData(lifecycle, it)
            }
        }
    }

    private fun initAdapter() {
        schoolListAdapter.addLoadStateListener { loadState ->
            val isListEmpty =
                loadState.refresh is LoadState.NotLoading && schoolListAdapter.itemCount == 0
            binding.tvNoResults.isVisible = isListEmpty

            binding.rcSchoolList.isVisible = loadState.source.refresh is LoadState.NotLoading

            // show loading when loading more
            handleLoading(loadState.source.refresh is LoadState.Loading)

            // show error when error loading more
            binding.btnRetry.isVisible = loadState.source.refresh is LoadState.Error

            val errorState = when {
                loadState.append is LoadState.Error -> loadState.append as LoadState.Error
                loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
                loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
                else -> null
            }
            errorState?.let {
                showToastMessage(it.error.message.toString())
            }
        }
    }

    private fun bindEvents() {
        with(binding) {
            rcSchoolList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    fab.isVisible = dy < START_POSITION

                    val scrollPosition =
                        (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
                    refreshLayout.isEnabled = scrollPosition == START_POSITION
                }
            })

            fab.setOnClickListener {
                rcSchoolList.smoothScrollToPosition(START_POSITION)
            }

            refreshLayout.setOnRefreshListener {
                schoolListAdapter.refresh()
            }

            btnRetry.setOnClickListener {
                schoolListAdapter.retry()
            }
        }
    }

    private fun handleLoading(loading: Boolean) {
        with(binding) {
            refreshLayout.isRefreshing = loading == true
        }
    }


}