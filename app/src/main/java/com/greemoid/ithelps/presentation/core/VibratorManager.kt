package com.greemoid.ithelps.presentation.core

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import com.greemoid.ithelps.core.presentation.BaseVibratorManager

class VibratorManager(private val context: Context) : BaseVibratorManager {
    override fun vibrate() {
        val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if (Build.VERSION.SDK_INT >= 26) {
            vibrator.vibrate(
                VibrationEffect.createOneShot(
                    400, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            vibrator.vibrate(400)
        }
    }

}