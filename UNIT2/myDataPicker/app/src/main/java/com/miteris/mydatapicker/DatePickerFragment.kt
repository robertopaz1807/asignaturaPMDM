package com.miteris.mydatapicker

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment

class DatePickerFragment (
    val listener: (day: Int, month: Int, year: Int) -> Unit):
    DialogFragment(), DatePickerDialog.OnDateSetListener{




    override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {
        listener(day, month, year)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
    //    val picker = DatePickerDialog(activity as Context, this, year, month, day)
        val picker = DatePickerDialog(activity as Context, R.style.DatePickerTheme, this, year, month, day)

        // picker.datePicker

        // c.add(Calendar.YEAR, -2)
        //picker.datePicker.maxDate = c.timeInMillis

        picker.datePicker.minDate = c.timeInMillis
        c.add(Calendar.MONTH, +2)
        picker.datePicker.maxDate = c.timeInMillis


        return picker
    }

}