package dev.lizarraga.dialogos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import dev.lizarraga.dialogos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDialogoSimple.setOnClickListener{
            crearDialogoSimple().show()
        }
        binding.btnDialogoConLista.setOnClickListener {
            crearDialogoConLista().show()
        }
        binding.btnDialogoConListaRadio.setOnClickListener {
            crearDialogoConListaRadio().show()
        }
        binding.btnDialogoConListaCheckbox.setOnClickListener {
            crearDialogoConListaCheckbox().show()
        }
        binding.btnDialogoPersonalizado.setOnClickListener {
            crearDialogoPersonalizado()
        }

    }

    fun crearDialogoSimple() : AlertDialog {

        return null!!
    }

    fun crearDialogoConLista(): AlertDialog {

        return null!!
    }

    fun crearDialogoConListaRadio(): AlertDialog {
        val alertDialog = AlertDialog.Builder(this)
        val opciones = arrayOf("Femenino", "Masculino", "Sin especificar")
        var posicion = 0

        return alertDialog.create()
    }

    fun crearDialogoConListaCheckbox(): AlertDialog {
        val alertDialog = AlertDialog.Builder(this)
        val opciones = arrayOf("Android", "iOS", "Java", "Kotlin")
        var itemSeleccionados = ArrayList<Int>()


        return alertDialog.create()
    }

    fun crearDialogoPersonalizado() {

    }
}