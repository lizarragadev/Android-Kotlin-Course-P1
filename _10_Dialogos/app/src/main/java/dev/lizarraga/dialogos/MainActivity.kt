package dev.lizarraga.dialogos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import dev.lizarraga.dialogos.databinding.ActivityMainBinding
import dev.lizarraga.dialogos.databinding.CustomDialogBinding

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
        val alertDialog = AlertDialog.Builder(this)
        alertDialog
            .setTitle("Mi Dialogo")
            .setMessage("Este es el contenido del dialogo")
            .setCancelable(false)
            .setPositiveButton("Aceptar") { a, d ->
                Toast.makeText(this, "Aceptado", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Rechazar") { a, d ->
                Toast.makeText(this, "Rechazado", Toast.LENGTH_SHORT).show()
            }
            .setNeutralButton("Cancelar") { a, d ->
                Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT).show()
            }
        return alertDialog.create()
    }

    fun crearDialogoConLista(): AlertDialog {
        val alertDialog = AlertDialog.Builder(this)
        val opciones = arrayOf("Opción 1", "Opción 2", "Opción 3")
        alertDialog
            .setTitle("Selecciona una opción")
            .setCancelable(false)
            .setItems(opciones) { a, i ->
                Toast.makeText(this, "Click en $i", Toast.LENGTH_SHORT).show()
            }
            .setNeutralButton("Cancelar") { a, d ->
                Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT).show()
            }
        return alertDialog.create()
    }

    fun crearDialogoConListaRadio(): AlertDialog {
        val alertDialog = AlertDialog.Builder(this)
        var posicion = 0
        val opciones = arrayOf("Femenino", "Masculino", "Sin especificar")
        alertDialog
            .setTitle("Dialogo lista radio")
            .setCancelable(false)
            .setSingleChoiceItems(opciones, 0) { a, i ->
                posicion = i
            }
            .setPositiveButton("Aceptar") { a, d ->
                Toast.makeText(this, "Seleccionado $posicion", Toast.LENGTH_SHORT).show()
            }

        return alertDialog.create()
    }

    fun crearDialogoConListaCheckbox(): AlertDialog {
        val alertDialog = AlertDialog.Builder(this)
        val opciones = arrayOf("Android", "iOS", "Java", "Kotlin")
        var itemSeleccionados = ArrayList<Int>()
        
        alertDialog
            .setTitle("Un dialogo con lista checkbox")
            .setCancelable(false)
            .setMultiChoiceItems(opciones, null) { a, i, b ->
                if (b) {
                    itemSeleccionados.add(i)
                } else  {
                    if(itemSeleccionados.contains(i)) {
                        itemSeleccionados.remove(i)
                    }
                }
            }
            .setPositiveButton("Aceptar") { a, d ->
                var texto = ""
                for (i in itemSeleccionados) {
                    texto += "$i "
                }
                Toast.makeText(this, "Seleccionados $texto", Toast.LENGTH_SHORT).show()
            }

        return alertDialog.create()
    }

    fun crearDialogoPersonalizado() {
        val bind = CustomDialogBinding.inflate(layoutInflater)
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setCancelable(false)
        alertDialog.setView(bind.root)
        val dialog = alertDialog.show()
        bind.btnCrear.setOnClickListener {
            dialog.dismiss()
        }
        bind.btnEntrar.setOnClickListener {
            Toast.makeText(this, "Bienvenido ${bind.etNombre.text}", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
    }
}