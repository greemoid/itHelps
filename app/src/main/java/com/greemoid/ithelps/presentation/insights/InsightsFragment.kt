package com.greemoid.ithelps.presentation.insights

import android.view.View
import com.greemoid.ithelps.core.presentation.BaseFragment
import com.greemoid.ithelps.databinding.FragmentInsightsBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class InsightsFragment :
    BaseFragment<InsightsViewModel, FragmentInsightsBinding>(FragmentInsightsBinding::inflate) {

    override val viewModel: InsightsViewModel by sharedViewModel()
    override val visibility: Int = View.VISIBLE
    private val adapterMood: InsightsMoodAdapter = InsightsMoodAdapter()
    private val adapterDiary: InsightsDiaryAdapter = InsightsDiaryAdapter()

    override fun init() {
        setupRecyclerView()
        viewModel.listMoods.observe(viewLifecycleOwner) {
            adapterMood.submitList(it.asReversed())
        }

        viewModel.listDiary.observe(viewLifecycleOwner) {
            adapterDiary.submitList(it.asReversed())
        }
    }

    private fun setupRecyclerView() {
        val recyclerViewMood = binding.rvMoods
        val recyclerViewDiary = binding.rvDiary
        recyclerViewMood.adapter = adapterMood
        recyclerViewDiary.adapter = adapterDiary
    }

}