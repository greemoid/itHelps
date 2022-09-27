package com.greemoid.ithelps.presentation.insights.mood

import android.view.View
import androidx.fragment.app.viewModels
import com.greemoid.ithelps.R
import com.greemoid.ithelps.core.presentation.BaseFragment
import com.greemoid.ithelps.databinding.FragmentMoodListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoodListFragment :
    BaseFragment<MoodListViewModel, FragmentMoodListBinding>(FragmentMoodListBinding::inflate) {
    override val viewModel: MoodListViewModel by viewModels()
    override val visibility: Int = View.GONE
    private val adapter = InsightsMoodAdapter(0)

    override fun init() {
        binding.btnBackToInsights.navigate(R.id.action_moodListFragment_to_insightsFragment)
        binding.rvMoods.adapter = adapter
        viewModel.listMoods.observe(this) { list ->
            adapter.differ.submitList(list.asReversed())
        }
    }
}