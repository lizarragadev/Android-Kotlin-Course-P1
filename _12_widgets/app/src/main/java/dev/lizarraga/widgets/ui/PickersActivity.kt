package dev.lizarraga.widgets.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.lizarraga.widgets.R
import dev.lizarraga.widgets.databinding.ActivityPickersBinding

class PickersActivity : AppCompatActivity() {
    lateinit var binding: ActivityPickersBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPickersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ibFecha.setOnClickListener {

        }

        binding.ibHora.setOnClickListener {

        }
    }
}