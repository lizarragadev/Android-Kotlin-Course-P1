package dev.lizarraga.intents

import android.app.Activity
import android.app.SearchManager
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import dev.lizarraga.intents.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener{
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
        binding.ibAbrirMarcado. setOnClickListener(this)
        binding.ibLlamar. setOnClickListener(this)
        binding.ibAbrirGoogleMaps.setOnClickListener(this)
        binding.ibAbrirStreetView. setOnClickListener(this)
        binding.ibAbrirPaginaWeb.setOnClickListener(this)
        binding.ibAbrirBuscador.setOnClickListener(this)
        binding.ibCompartirTexto.setOnClickListener(this)
        binding.ibCapturaImagen.setOnClickListener(this)
        binding.ibEnviarEmail.setOnClickListener(this)
        binding.ibAbrirApp.setOnClickListener(this)

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

    override fun onClick(v: View?) {
        when(v?.id) {
            binding.ibAbrirMarcado.id -> abrirMarcado()
            binding.ibLlamar.id -> llamar()
            binding.ibAbrirGoogleMaps.id -> abrirGoogleMaps()
            binding.ibAbrirStreetView.id -> abrirStreetView()
            binding.ibAbrirPaginaWeb.id -> abrirPaginaWeb()
            binding.ibAbrirBuscador.id -> abrirBuscador()
            binding.ibCompartirTexto.id -> compartirTexto()
            binding.ibCapturaImagen.id -> capturaImagen()
            binding.ibEnviarEmail.id -> enviarEmail()
            binding.ibAbrirApp.id -> abrirApp()
        }
    }

    private fun abrirApp() {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.setClassName("com.facebook.katana", "com.facebook.katana.LoginActivity")
        startActivity(intent)
    }

    private fun enviarEmail() {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.type = "text/plain"
        intent.data = Uri.parse("mailto:")
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("gus@gus.com", "juan@juan.com"))
        intent.putExtra(Intent.EXTRA_CC, arrayOf("maria@maria.com"))
        intent.putExtra(Intent.EXTRA_SUBJECT, "Asunto del correo")
        intent.putExtra(Intent.EXTRA_TEXT, "Este es el contenido del correo")

        startActivity(intent)
    }

    private fun capturaImagen() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        resultCamera.launch(intent)
    }

    val resultCamera = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if(result.resultCode == Activity.RESULT_OK) {
            val bitmap = result.data?.extras?.get("data") as Bitmap
            binding.ibCapturaImagen.setImageBitmap(bitmap)
        } else {
            Toast.makeText(this, "No se capturó la imagen", Toast.LENGTH_SHORT).show()
        }
    }

    private fun compartirTexto() {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, "Compartiendo texto desde mi app")
        startActivity(intent)
    }

    private fun abrirBuscador() {
        val intent = Intent(Intent.ACTION_WEB_SEARCH)
        intent.putExtra(SearchManager.QUERY, "Android")
        startActivity(intent)
    }

    private fun abrirPaginaWeb() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://www.google.com")
        startActivity(intent)
    }

    private fun abrirStreetView() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("google.streetview:cbll=-16.540932,-68.087170")
        startActivity(intent)
    }

    private fun abrirGoogleMaps() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("geo:-16.540932,-68.087170")
        startActivity(intent)
    }

    private fun llamar() {
        val permissionCheck = ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE)
        if(permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE), 1)
        } else {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:77752810")
            startActivity(intent)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode) {
            555 -> {
                if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    llamar()
                } else {
                    Toast.makeText(this, "No se puede realizar la llamada sin permisos", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun abrirMarcado() {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:77752810")
        startActivity(intent)
    }
}