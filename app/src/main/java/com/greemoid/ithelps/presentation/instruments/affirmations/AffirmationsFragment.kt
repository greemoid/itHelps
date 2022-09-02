package com.greemoid.ithelps.presentation.instruments.affirmations

import android.view.View
import com.greemoid.ithelps.core.presentation.BaseFragment
import com.greemoid.ithelps.data.source.AffirmationDataSource
import com.greemoid.ithelps.databinding.FragmentAffirmationsBinding
import com.greemoid.ithelps.presentation.dailyTasks.DailyTasksViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class AffirmationsFragment :
    BaseFragment<DailyTasksViewModel, FragmentAffirmationsBinding>(FragmentAffirmationsBinding::inflate) {

    override val viewModel: DailyTasksViewModel by sharedViewModel()
    override val visibility: Int = View.GONE

    override fun init() {
        val affirmationsList = AffirmationDataSource().load().shuffled()
        val viewPager = binding.viewPager
        val viewPagerAdapter = AffirmationsViewPagerAdapter(requireContext(), affirmationsList)
        viewPager.adapter = viewPagerAdapter
        viewPager.offscreenPageLimit = 10
    }
}
