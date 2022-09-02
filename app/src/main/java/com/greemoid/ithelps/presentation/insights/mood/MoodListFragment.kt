package com.greemoid.ithelps.presentation.insights.mood

import android.view.View
import com.greemoid.ithelps.R
import com.greemoid.ithelps.core.presentation.BaseFragment
import com.greemoid.ithelps.databinding.FragmentMoodListBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MoodListFragment :
    BaseFragment<MoodListViewModel, FragmentMoodListBinding>(FragmentMoodListBinding::inflate) {
    override val viewModel: MoodListViewModel by sharedViewModel()
    override val visibility: Int = View.GONE
    private val adapter = InsightsMoodAdapter(0)

    override fun init() {
        binding.btnBackToInsights.navigate(R.id.action_moodListFragment_to_insightsFragment)
        binding.rvMoods.adapter = adapter
        viewModel.listMoods.observe(this) { list ->
            adapter.submitList(list.asReversed())
        }
    }
}