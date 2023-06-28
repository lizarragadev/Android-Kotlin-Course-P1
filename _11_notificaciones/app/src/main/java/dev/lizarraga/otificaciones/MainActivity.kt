package dev.lizarraga.otificaciones

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.NotificationCompat
import dev.lizarraga.otificaciones.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityMainBinding
    lateinit var mNotificationManager: NotificationManager
    private val CANAL_ID = "miCanal01"
    private val CANAL_NOMBRE = "Mi canal de notificaciones"
    private val CANAL_DESCRIPCION = "Este es un canal para mis notificaciones..."
    private val NOTIFICATION_ID = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mNotificationManager = applicationContext
            .getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importancia = NotificationManager.IMPORTANCE_DEFAULT
            val canal = NotificationChannel(CANAL_ID, CANAL_NOMBRE, importancia)
            canal.description = CANAL_DESCRIPCION
            canal.enableLights(true)
            canal.enableVibration(true)
            canal.lockscreenVisibility = NotificationManager.IMPORTANCE_DEFAULT
            mNotificationManager.createNotificationChannel(canal)
        }

        binding.btnNotificacionSimple.setOnClickListener(this)
        binding.btnNotificacionGrande.setOnClickListener(this)
        binding.btnNotificacionImagenGrande.setOnClickListener(this)
        binding.btnNotificacionAcciones.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btnNotificacionSimple -> crearNotificacionSimple()
            R.id.btnNotificacionGrande -> crearNotificacionTextoGrande()
            R.id.btnNotificacionImagenGrande -> crearNotificacionImagenGrande()
            R.id.btnNotificacionAcciones -> crearNotificacionConAcciones()
        }
    }

    private fun crearNotificacionConAcciones() {
        TODO("Not yet implemented")
    }

    private fun crearNotificacionImagenGrande() {
        TODO("Not yet implemented")
    }

    private fun crearNotificacionTextoGrande() {
        TODO("Not yet implemented")
    }

    private fun crearNotificacionSimple() {
        val notificacion = NotificationCompat.Builder(this, CANAL_ID)
        notificacion
            .setContentTitle("Titulo de notificacion")
            .setContentText("Este es el texto de la notificacion")
            .setSmallIcon(android.R.drawable.ic_dialog_alert)
            .setLargeIcon(BitmapFactory.decodeResource(this.resources, android.R.drawable.ic_dialog_email))

        mNotificationManager.notify(NOTIFICATION_ID, notificacion.build())
    }
}