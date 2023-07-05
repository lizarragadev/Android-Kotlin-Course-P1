package dev.lizarraga.listas_personalizadas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import dev.lizarraga.listas_personalizadas.adapter.CustomAdapter
import dev.lizarraga.listas_personalizadas.databinding.ActivityMainBinding
import dev.lizarraga.listas_personalizadas.model.Pokemon

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    lateinit var binding: ActivityMainBinding
    lateinit var datos: ArrayList<Pokemon>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        llenarPokemones()

        val adaptador = CustomAdapter(this, datos)
        binding.lvDatos.adapter = adaptador
        binding.lvDatos.onItemClickListener = this
    }

    private fun llenarPokemones() {
        datos = ArrayList()
        val arrayTitulos = resources.getStringArray(R.array.titulos)
        val arraySubtitulos = resources.getStringArray(R.array.subtitulos)
        val arrayImagenes = resources.obtainTypedArray(R.array.imagenes)

        for(i in arrayTitulos.indices) {
            val poke = Pokemon()
            poke.titulo = arrayTitulos[i]
            poke.subtitulo = arraySubtitulos[i]
            poke.imagen = arrayImagenes.getResourceId(i, -1)
            datos.add(poke)
        }
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val intent = Intent(this, DetalleActivity::class.java)
        intent.putExtra("poke", datos[position])
        startActivity(intent)
    }
}