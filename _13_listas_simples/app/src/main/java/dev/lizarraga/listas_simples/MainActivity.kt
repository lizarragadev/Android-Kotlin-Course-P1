package dev.lizarraga.listas_simples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import dev.lizarraga.listas_simples.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val paises = resources.getStringArray(R.array.paises)

        val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, paises)

        binding.lvDatos.adapter = adaptador

        binding.lvDatos.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "Hizo click en ${paises[position]}", Toast.LENGTH_LONG).show()
        }
    }
}