package dev.lizarraga.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import dev.lizarraga.intents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ibAbrirActivity.setOnClickListener{
            abrirActivity()
        }

        binding.ibEnviarDatos.setOnClickListener {
            enviarDatos()
        }

        binding.ibDevolverDatos.setOnClickListener {
            devolverDatos()
        }
    }

    private fun abrirActivity(){
        startActivity(Intent(this, SegundaActivity::class.java))
    }

    private fun enviarDatos(){
        val intent = Intent(this, SegundaActivity::class.java)
        intent.putExtra("valor1", "Hola desde MainActivity")
        intent.putExtra("valor2", 87 )
        startActivity(intent)
    }

    private fun devolverDatos() {
        val intent = Intent(this, SegundaActivity::class.java)
        intent.putExtra("valor3", "Mi nombre es...")
        resultDevolverDatos.launch(intent)
    }

    val resultDevolverDatos = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val resultado = result.data?.getStringExtra("respuesta")
            Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show()
        }
    }
}