package dev.lizarraga.listas_personalizadas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.lizarraga.listas_personalizadas.databinding.ActivityDetalleBinding
import dev.lizarraga.listas_personalizadas.model.Pokemon

class DetalleActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pokemon = intent.getSerializableExtra("poke") as Pokemon

        binding.tvTitulo.text = pokemon.titulo
        binding.tvSubtitulo.text = pokemon.subtitulo
        binding.ivImagen.setImageResource(pokemon.imagen)
    }
}