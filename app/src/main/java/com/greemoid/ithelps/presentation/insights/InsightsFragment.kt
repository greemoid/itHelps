package com.greemoid.ithelps.presentation.insights

import android.view.View
import com.greemoid.ithelps.R
import com.greemoid.ithelps.core.presentation.BaseFragment
import com.greemoid.ithelps.databinding.FragmentInsightsBinding
import com.greemoid.ithelps.presentation.insights.diary.InsightsDiaryAdapter
import com.greemoid.ithelps.presentation.insights.mood.InsightsMoodAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class InsightsFragment :
    BaseFragment<InsightsViewModel, FragmentInsightsBinding>(FragmentInsightsBinding::inflate) {

    override val viewModel: InsightsViewModel by sharedViewModel()
    override val visibility: Int = View.VISIBLE
    private val adapterMood: InsightsMoodAdapter = InsightsMoodAdapter(5)
    private val adapterDiary: InsightsDiaryAdapter = InsightsDiaryAdapter(5)

    override fun init() {
        setupRecyclerView()
        viewModel.listMoods.observe(viewLifecycleOwner) {
            adapterMood.submitList(it.asReversed())
        }

        viewModel.listDiary.observe(viewLifecycleOwner) {
            adapterDiary.submitList(it.asReversed())
        }
        binding.btnDiary.navigate(R.id.action_insightsFragment_to_diaryListFragment)
        binding.btnMoods.navigate(R.id.action_insightsFragment_to_moodListFragment)
    }

    private fun setupRecyclerView() {
        val recyclerViewMood = binding.rvMoods
        val recyclerViewDiary = binding.rvDiary
        recyclerViewMood.adapter = adapterMood
        recyclerViewDiary.adapter = adapterDiary
    }

}