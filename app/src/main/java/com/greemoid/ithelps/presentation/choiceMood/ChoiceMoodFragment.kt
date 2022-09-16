package com.greemoid.ithelps.presentation.choiceMood

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.greemoid.ithelps.R
import com.greemoid.ithelps.core.presentation.BaseFragment
import com.greemoid.ithelps.databinding.FragmentChoiceMoodBinding
import com.greemoid.ithelps.domain.models.mood.MoodDataSet
import com.greemoid.ithelps.presentation.core.EmptyViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class ChoiceMoodFragment :
    BaseFragment<EmptyViewModel, FragmentChoiceMoodBinding>(FragmentChoiceMoodBinding::inflate) {

    private lateinit var adapter: ChoiceMoodAdapter
    override val viewModel: EmptyViewModel by sharedViewModel()
    override val visibility: Int = View.GONE

    override fun init() {
        setupRecyclerView()
        adapter.setOnItemClickListener {
            val bundle = Bundle()
            bundle.putSerializable("moodType", it)
            findNavController().navigate(R.id.action_choiceMoodFragment_to_moodAddFragment, bundle)
        }
    }

    private fun setupRecyclerView() {
        val dataSource = MoodDataSet().load()
        val recyclerView = binding.rvMoods
        adapter = ChoiceMoodAdapter(dataSource)
        recyclerView.adapter = adapter
    }
}