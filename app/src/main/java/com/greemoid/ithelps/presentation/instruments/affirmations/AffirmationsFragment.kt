package com.greemoid.ithelps.presentation.instruments.affirmations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.greemoid.ithelps.data.models.Affirmation
import com.greemoid.ithelps.data.source.AffirmationDataSource
import com.greemoid.ithelps.databinding.FragmentAffirmationsBinding
import com.greemoid.ithelps.presentation.MainActivity


class AffirmationsFragment : Fragment() {

    private lateinit var binding: FragmentAffirmationsBinding
    private lateinit var viewPager: ViewPager
    private lateinit var viewPagerAdapter: AffirmationsViewPagerAdapter
    private lateinit var affirmationsList: List<Affirmation>
    private val affirmationsDataSource = AffirmationDataSource()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentAffirmationsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        affirmationsList = affirmationsDataSource.load().shuffled()
        viewPager = binding.viewPager
        viewPagerAdapter = AffirmationsViewPagerAdapter(requireContext(), affirmationsList)
        viewPager.adapter = viewPagerAdapter
        viewPager.offscreenPageLimit = 10
    }

    override fun onResume() {
        super.onResume()
        if (activity is MainActivity) {
            val mainActivity = activity as MainActivity
            mainActivity.setBottomNavigationVisibility(View.GONE)
        }
    }


}