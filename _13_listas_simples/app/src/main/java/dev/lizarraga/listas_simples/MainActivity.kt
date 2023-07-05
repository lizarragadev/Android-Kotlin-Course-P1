package dev.lizarraga.listas_simples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.lizarraga.listas_simples.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}