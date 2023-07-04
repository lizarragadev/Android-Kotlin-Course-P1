package dev.lizarraga.widgets.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import dev.lizarraga.widgets.R
import dev.lizarraga.widgets.databinding.ActivityWidgetsBinding

class WidgetsActivity : AppCompatActivity() {
    lateinit var binding: ActivityWidgetsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWidgetsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sbUno.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                Toast.makeText(applicationContext, "${seekBar?.progress}", Toast.LENGTH_LONG).show()
            }

        })

        binding.rbStars.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            Toast.makeText(this, "Valor: $rating / ${ratingBar.numStars}",
                Toast.LENGTH_LONG).show()
        }

    }
}