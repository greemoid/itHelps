package com.greemoid.ithelps.presentation.instruments.answers

import android.app.*
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.os.Build
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.greemoid.ithelps.core.presentation.BaseFragment
import com.greemoid.ithelps.databinding.FragmentQuestionsAndAnswersBinding
import com.greemoid.ithelps.presentation.core.EmptyViewModel
import com.greemoid.ithelps.presentation.todo.add.channelID
import com.greemoid.ithelps.presentation.todo.add.messageExtra
import com.greemoid.ithelps.presentation.todo.add.notificationID
import com.greemoid.ithelps.presentation.todo.add.titleExtra
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.util.*


class QuestionsAndAnswersFragment :
    BaseFragment<EmptyViewModel, FragmentQuestionsAndAnswersBinding>(
        FragmentQuestionsAndAnswersBinding::inflate) {
    override val viewModel: EmptyViewModel by sharedViewModel()
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
            Snackbar.make(binding.linearLayout,
                "Sorry, you can't make notification because your version too small",
                Snackbar.LENGTH_SHORT).show()
        }

        val alarmManager = activity?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val time = getTime()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setExactAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                time,
                pendingIntent
            )
        } else {
            Snackbar.make(binding.linearLayout,
                "Sorry, you can't make notification because your version too small",
                Snackbar.LENGTH_SHORT).show()
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
            Snackbar.make(binding.linearLayout,
                "Sorry, you can't make notification because your version too small",
                Snackbar.LENGTH_SHORT).show()
        }
        val day = binding.datePicker.dayOfMonth
        val month = binding.datePicker.month
        val year = binding.datePicker.year

        val calendar = Calendar.getInstance()
        calendar.set(year, month, day, hour, minute)
        return calendar.timeInMillis
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Notif Channel"
            val desc = "A Description of the Channel"
            val importance = NotificationManager.IMPORTANCE_DEFAULT

            val channel = NotificationChannel(channelID, name, importance)
            channel.description = desc

            val notificationManager =
                activity?.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        } else {
            Snackbar.make(binding.linearLayout,
                "Sorry, you can't make notification because your version too small",
                Snackbar.LENGTH_SHORT).show()
        }
    }
}
