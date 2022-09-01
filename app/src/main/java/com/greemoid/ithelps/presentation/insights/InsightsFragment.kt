package com.greemoid.ithelps.presentation.insights

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.greemoid.ithelps.databinding.FragmentInsightsBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class InsightsFragment : Fragment() {

    private lateinit var binding: FragmentInsightsBinding
    private val viewModel: InsightsViewModel by sharedViewModel()
    private lateinit var recyclerViewMood: RecyclerView
    private lateinit var adapterMood: InsightsMoodAdapter
    private lateinit var recyclerViewDiary: RecyclerView
    private lateinit var adapterDiary: InsightsDiaryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInsightsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        viewModel.listMoods.observe(viewLifecycleOwner) {
            adapterMood.submitList(it.asReversed())
        }

        viewModel.listDiary.observe(viewLifecycleOwner) {
            adapterDiary.submitList(it.asReversed())
        }

    }

    private fun setupRecyclerView() {
        recyclerViewMood = binding.rvMoods
        recyclerViewDiary = binding.rvDiary
        adapterMood = InsightsMoodAdapter()
        adapterDiary = InsightsDiaryAdapter()
        recyclerViewMood.adapter = adapterMood
        recyclerViewDiary.adapter = adapterDiary
    }

}