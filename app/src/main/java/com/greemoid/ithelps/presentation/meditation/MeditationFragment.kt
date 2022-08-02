package com.greemoid.ithelps.presentation.meditation

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.greemoid.ithelps.databinding.FragmentMeditationBinding
import java.util.*


class MeditationFragment : Fragment() {

    private lateinit var binding: FragmentMeditationBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentMeditationBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val timer = object : CountDownTimer(900000, 1000) {

            // Callback function, fired on regular interval
            override fun onTick(millisUntilFinished: Long) {
                val seconds = millisUntilFinished / 1000
                val minutes = (seconds % 3600) / 60
                val secs = seconds % 60

                val time = String.format(Locale.getDefault(), "%02d:%02d", minutes, secs)

                binding.tvTimer.text = time
            }

            // Callback function, fired
            // when the time is up
            override fun onFinish() {
                binding.tvTimer.text = "done!"
            }
        }

        binding.btnStart.setOnClickListener {
            timer.start()
        }

        binding.btnStop.setOnClickListener {
            timer.cancel()
            binding.tvTimer.text = "00:00"
        }
    }



}