package dev.lizarraga.funcionalidad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dev.lizarraga.funcionalidad.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSumar.setOnClickListener {
            if(valida())
                operar(1)
            else
                printMessage(1)
        }
        binding.btnRestar.setOnClickListener {
            if(valida())
                operar(2)
            else
                printMessage(1)
        }
        binding.btnMultiplicar.setOnClickListener {
            if(valida())
                operar(3)
            else
                printMessage(1)
        }
        binding.btnDividir.setOnClickListener {
            if(valida())
                if(binding.etNumero2.text.toString().toInt() != 0)
                    operar(4)
                else
                    printMessage(2)
            else
                printMessage(1)
        }
    }

    private fun printMessage(tipo: Int) {
        if(tipo == 1)
            Toast.makeText(this, "Existen campos vacíos", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(this, "No se puede realizar la division entre cero", Toast.LENGTH_SHORT).show()
    }

    private fun operar(tipo: Int) {
        val num1 = binding.etNumero1.text.toString().toInt()
        val num2 = binding.etNumero2.text.toString().toInt()

        binding.tvResultado.text = when(tipo) {
            1 -> "La suma es: ${num1 + num2}"
            2 -> "La resta es: ${num1 - num2}"
            3 -> "La multiplicación es: ${num1 * num2}"
            4 -> "La división es: ${num1.toDouble() / num2.toDouble()}"
            else -> "Error"
        }
    }

    fun valida() = binding.etNumero1.text.toString() != "" && binding.etNumero2.text.toString() != ""
}