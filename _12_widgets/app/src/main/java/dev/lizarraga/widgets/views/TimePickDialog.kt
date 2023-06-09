package dev.lizarraga.widgets.views

import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.text.format.DateFormat
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import dev.lizarraga.widgets.DateTimeInterface
import java.util.Calendar

class TimePickDialog : DialogFragment(), TimePickerDialog.OnTimeSetListener {

    var timePickerDialog: TimePickerDialog? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)

        timePickerDialog = TimePickerDialog(activity as Context, this, hour, minute, DateFormat.is24HourFormat(activity))

        return timePickerDialog as TimePickerDialog
    }

    override fun onTimeSet(p0: TimePicker?, hora: Int, minuto: Int) {
        val horaFormateada = if(hora < 10) "0$hora" else hora.toString()
        val minutoFormateado = if(minuto < 10) "0$minuto" else minuto.toString()
        val ampm = if(hora < 12) "a.m." else "p.m."
        val resultado = "$horaFormateada:$minutoFormateado $ampm"

        (activity as DateTimeInterface).obtieneHora(resultado)
    }

}