package com.greemoid.ithelps.presentation.todo.add

import android.app.*
import android.app.Notification
import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.View
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.greemoid.ithelps.R
import com.greemoid.ithelps.core.presentation.BaseFragment
import com.greemoid.ithelps.databinding.FragmentTodoAddBinding
import com.greemoid.ithelps.domain.models.todo.Task
import com.greemoid.ithelps.domain.models.todo.TaskTypes
import com.greemoid.ithelps.presentation.core.Date
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.util.*
import kotlin.properties.Delegates


class TodoAddFragment :
    BaseFragment<TodoAddViewModel, FragmentTodoAddBinding>(FragmentTodoAddBinding::inflate) {

    override val viewModel: TodoAddViewModel by sharedViewModel()
    override val visibility: Int = View.GONE

    override fun init() {
        binding.btnClose.setOnClickListener {
            findNavController().navigate(R.id.action_todoAddFragment_to_todoFragment)
        }

        createNotificationChannel()
        binding.submitButton.setOnClickListener { scheduleNotification() }

        binding.btnCustomDate.setOnClickListener {
            binding.btnCustomDate.visibility = View.GONE
            binding.datePicker.visibility = View.VISIBLE
            binding.btnSaveDate.visibility = View.VISIBLE
        }

        binding.btnSaveDate.setOnClickListener {
            val day = binding.datePicker.dayOfMonth
            val month = binding.datePicker.month
            val year = binding.datePicker.year
            binding.rbCustom.text = "${day}.${month}.${year}"
            binding.btnCustomDate.visibility = View.VISIBLE
            binding.datePicker.visibility = View.GONE
            binding.btnSaveDate.visibility = View.GONE
        }

        binding.btnSave.setOnClickListener {
            if (binding.etTitle.text.isNotEmpty()) {
                val title = binding.etTitle.text.toString()
                val description = binding.etDescription.text.toString()
                val taskType = when (binding.spinnerChapters.selectedItemId.toInt()) {
                    0 -> TaskTypes.IMPORTANTANDURGENT.chapter
                    1 -> TaskTypes.IMPORTANT.chapter
                    2 -> TaskTypes.URGENT.chapter
                    3 -> TaskTypes.NOTIMPORTANTANDNOTURGENT.chapter
                    4 -> TaskTypes.DAILY.chapter
                    5 -> TaskTypes.GROCERIES.chapter
                    6 -> TaskTypes.HISTORY.chapter
                    else -> ""
                }
                val dateClass = Date()
                val date = when (binding.radioGroupDates.checkedRadioButtonId) {
                    binding.rbToday.id -> dateClass.getCurrentFullDate()
                    binding.rbTomorrow.id -> dateClass.getTomorrow()
                    binding.rbCustom.id -> binding.rbCustom.text.toString()
                    else -> ""
                }
                val isDone = false
                val task = Task(
                    title,
                    description,
                    taskType,
                    date,
                    isDone
                )
                viewModel.saveTask(task)
                findNavController().navigate(R.id.action_todoAddFragment_to_todoFragment)
            } else {
                Snackbar
                    .make(
                        binding.root,
                        "Please, input your title",
                        Snackbar.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun scheduleNotification() {
        val intent = Intent(requireContext().applicationContext, Notification::class.java)
        val title = binding.etTitle.text.toString()
        val message = binding.etDescription.text.toString()
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
            Snackbar.make(binding.layout,
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
            Snackbar.make(binding.layout,
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
        val day = binding.datePickerNotification.dayOfMonth
        val month = binding.datePickerNotification.month
        val year = binding.datePickerNotification.year

        val calendar = Calendar.getInstance()
        calendar.set(year, month, day, hour, minute)
        return calendar.timeInMillis
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Notif Channel"
            val desc = "A Description of the Channel"
            val importance = NotificationManager.IMPORTANCE_HIGH

            val channel = NotificationChannel(channelID, name, importance)
            channel.description = desc

            val notificationManager =
                activity?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        } else {
            Snackbar.make(binding.linearLayout,
                "Sorry, you can't make notification because your version too small",
                Snackbar.LENGTH_SHORT).show()
        }
    }
}