package com.greemoid.ithelps.presentation.instruments.quotes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.greemoid.ithelps.data.models.Quote
import com.greemoid.ithelps.data.source.QuotesDataSource
import com.greemoid.ithelps.databinding.FragmentQuotesBinding
import com.greemoid.ithelps.presentation.MainActivity


class QuotesFragment : Fragment() {

    private lateinit var binding: FragmentQuotesBinding
    private lateinit var viewPager: ViewPager
    private lateinit var viewPagerAdapter: QuotesViewPagerAdapter
    private lateinit var quotesList: List<Quote>
    private val quotesDataSource = QuotesDataSource()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentQuotesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        quotesList = quotesDataSource.load().shuffled()
        viewPager = binding.viewPager
        viewPagerAdapter = QuotesViewPagerAdapter(requireContext(), quotesList)
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