package com.greemoid.ithelps.presentation.meditation

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.greemoid.ithelps.databinding.FragmentMeditationBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.util.*


class MeditationFragment : Fragment() {

    private lateinit var binding: FragmentMeditationBinding
    private val viewModel: MeditationViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentMeditationBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var etTime: String = ""
        var time: Long = 0
        binding.btnSetTime.setOnClickListener {
            etTime = binding.etTimer.text.toString()
            binding.etTimer.visibility = View.GONE
            binding.btnSetTime.visibility = View.GONE
            binding.tvTimer.visibility = View.VISIBLE
            binding.tvTimer.text = "$etTime:00"
            binding.etTimer.text = null
        }

        binding.btnStart.setOnClickListener {
            time = etTime.toLong() * 60000
            viewModel.startTimer(time)
        }

        binding.btnStop.setOnClickListener {
            viewModel.cancelTimer()
            etTime = ""
            time = 0
            binding.etTimer.visibility = View.VISIBLE
            binding.btnSetTime.visibility = View.VISIBLE
            binding.tvTimer.visibility = View.GONE
        }

        viewModel.millis.observe(viewLifecycleOwner) {
            binding.tvTimer.text = it
        }
    }



}