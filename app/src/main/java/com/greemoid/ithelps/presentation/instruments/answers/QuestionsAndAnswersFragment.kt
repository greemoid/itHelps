package com.greemoid.ithelps.presentation.instruments.answers

import android.app.*
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.os.Build
import android.util.Log
import android.view.View
import com.greemoid.ithelps.core.presentation.BaseFragment
import com.greemoid.ithelps.databinding.FragmentQuestionsAndAnswersBinding
import com.greemoid.ithelps.presentation.dailyTasks.DailyTasksViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.util.*


class QuestionsAndAnswersFragment :
    BaseFragment<DailyTasksViewModel, FragmentQuestionsAndAnswersBinding>(
        FragmentQuestionsAndAnswersBinding::inflate) {
    override val viewModel: DailyTasksViewModel by sharedViewModel()
    override val visibility: Int = View.GONE

    override fun init() {
        createNotificationChannel()
        binding.submitButton.setOnClickListener { scheduleNotification() }
    }

    private fun scheduleNotification() {
        val intent = Intent(requireContext().applicationContext, Notification::class.java)
        val title = binding.titleET.text.toString()
        val message = binding.messageET.text.toString()
        intent.putExtra(titleExtra, title)
        intent.putExtra(messageExtra, message)
        var pendingIntent: PendingIntent? = null

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            pendingIntent = PendingIntent.getBroadcast(
                requireContext().applicationContext,
                notificationID,
                intent,
                PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
            )
        } else {
            Log.d("NOT", "bad ver")
        }

        val alarmManager = activity?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val time = getTime()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setExactAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                time,
                pendingIntent
            )
        }
        showAlert(time, title, message)
    }

    private fun showAlert(time: Long, title: String, message: String) {
        val date = Date(time)
        val dateFormat =
            android.text.format.DateFormat.getLongDateFormat(requireContext().applicationContext)
        val timeFormat =
            android.text.format.DateFormat.getTimeFormat(requireContext().applicationContext)

        AlertDialog.Builder(requireContext())
            .setTitle("Notification Scheduled")
            .setMessage(
                "Title: " + title +
                        "\nMessage: " + message +
                        "\nAt: " + dateFormat.format(date) + " " + timeFormat.format(date))
            .setPositiveButton("Okay") { _, _ -> }
            .show()
    }

    private fun getTime(): Long {
        var minute = 0
        var hour = 0
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            minute = binding.timePicker.minute
            hour = binding.timePicker.hour
        } else {
            Log.d("NOT", "bad ver")
        }
        val day = binding.datePicker.dayOfMonth
        val month = binding.datePicker.month
        val year = binding.datePicker.year

        val calendar = Calendar.getInstance()
        calendar.set(year, month, day, hour, minute)
        return calendar.timeInMillis
    }

    private fun createNotificationChannel() {
        val name = "Notif Channel"
        val desc = "A Description of the Channel"
        val importance = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            NotificationManager.IMPORTANCE_DEFAULT
        } else {
            Log.d("NOT", "bad ver")
        }
        var channel: NotificationChannel? = null
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            channel = NotificationChannel(channelID, name, importance)
        } else {
            Log.d("NOT", "bad ver")
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            channel?.description = desc
        }
        val notificationManager =
            activity?.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(channel!!)
        }
    }
}
