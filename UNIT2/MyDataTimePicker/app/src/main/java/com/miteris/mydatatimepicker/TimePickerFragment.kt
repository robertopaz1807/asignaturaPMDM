package com.miteris.mydatatimepicker


import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment

class TimePickerFragment (val listener:(String) -> Unit) :
        DialogFragment(), TimePickerDialog.OnTimeSetListener {



    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        listener("$hourOfDay:$minute")
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)
        val picker = TimePickerDialog(activity as Context, this, hour, minute, true)
        return picker
    }



}
