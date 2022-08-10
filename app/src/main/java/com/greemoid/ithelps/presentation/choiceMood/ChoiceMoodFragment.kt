package com.greemoid.ithelps.presentation.choiceMood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.greemoid.ithelps.R
import com.greemoid.ithelps.databinding.FragmentChoiceMoodBinding
import com.greemoid.ithelps.domain.models.mood.MoodDataSet


class ChoiceMoodFragment : Fragment() {

    private lateinit var binding: FragmentChoiceMoodBinding
    private lateinit var adapter: ChoiceMoodAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentChoiceMoodBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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