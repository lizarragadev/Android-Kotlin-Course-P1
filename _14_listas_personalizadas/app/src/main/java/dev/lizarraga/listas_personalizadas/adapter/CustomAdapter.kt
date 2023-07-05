package dev.lizarraga.listas_personalizadas.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import dev.lizarraga.listas_personalizadas.databinding.ItemListaBinding
import dev.lizarraga.listas_personalizadas.model.Pokemon

class CustomAdapter(context: Context, val data: ArrayList<Pokemon>)
    : ArrayAdapter<Pokemon>(context, 0, data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ItemListaBinding.inflate(LayoutInflater.from(context), parent, false)

        val pokemonActual = data[position]

        binding.tvTitulo.text = pokemonActual.titulo
        binding.tvSubtitulo.text = pokemonActual.subtitulo
        binding.ivImagen.setImageResource(pokemonActual.imagen)

        return binding.root
    }
}