package com.example.android_practice.uiwidgets

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import android.widget.CalendarView.OnDateChangeListener
import android.widget.DatePicker
import android.widget.TimePicker
import com.example.android_practice.databinding.ActivityCalendarViewBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class CalendarView : AppCompatActivity() {


    private lateinit var binding: ActivityCalendarViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCalendarViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val calendar = Calendar.getInstance()
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH))

        val endOfMonth = calendar.timeInMillis

        binding.calendarView.maxDate = endOfMonth

        binding.datePicker.minDate = endOfMonth

        //Simple CalenderView
        binding.calendarView.setOnDateChangeListener(object : OnDateChangeListener{
            override fun onSelectedDayChange(view: CalendarView, year: Int, month: Int, dayOfMonth: Int) {
                val date = dayOfMonth.toString() + "-" + month + "-" + year

                binding.dateSelect.text = date
            }

        })

        //Custom Date Picker
        val dateSetListner = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                calendar.set(Calendar.YEAR,year)
                calendar.set(Calendar.MONTH, month)
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                val date = dayOfMonth.toString() + "-" + month + "-" + year
                binding.txtDate.setText(date)
                updateDateInView(calendar)
            }
        binding.imgClock.setOnClickListener {
            DatePickerDialog(this, dateSetListner, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show()
        }

        val timeListner = object : OnTimeSetListener {
            override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                calendar.set(Calendar.HOUR, hourOfDay)
                calendar.set(Calendar.MINUTE,minute)
                val time = hourOfDay.toString() + ":" + minute
                binding.txtTime.setText(time)
            }

        }

        binding.imgClocKTime.setOnClickListener {
           val timePicker = TimePickerDialog(this, timeListner, calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE), true)
            timePicker.show()
        }

    }

    fun updateDateInView(calender: Calendar) {
        val sdf = SimpleDateFormat("EEEE, dd, MMM, yyyy", Locale.UK)
        binding.txtDate.setText(sdf.format(calender.time))
    }
}