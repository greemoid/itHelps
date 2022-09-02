package com.greemoid.ithelps.presentation.instruments.quotes

import android.view.View
import com.greemoid.ithelps.core.presentation.BaseFragment
import com.greemoid.ithelps.data.source.QuotesDataSource
import com.greemoid.ithelps.databinding.FragmentQuotesBinding
import com.greemoid.ithelps.presentation.dailyTasks.DailyTasksViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class QuotesFragment :
    BaseFragment<DailyTasksViewModel, FragmentQuotesBinding>(FragmentQuotesBinding::inflate) {

    //todo make quotes and affirmations as one fragment but with different lists

    override val viewModel: DailyTasksViewModel by sharedViewModel()
    override val visibility: Int = View.GONE

    override fun init() {
        val quotesList = QuotesDataSource().load().shuffled()
        val viewPager = binding.viewPager
        val viewPagerAdapter = QuotesViewPagerAdapter(requireContext(), quotesList)
        viewPager.adapter = viewPagerAdapter
        viewPager.offscreenPageLimit = 10
    }

}