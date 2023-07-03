package dev.lizarraga.otificaciones

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
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
        val notificacion = NotificationCompat.Builder(this, CANAL_ID)
        notificacion
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Botones")
            .setContentText("Contenido notificacion con botones")

        val intent = Intent(this, ResultadoActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0,
            intent, PendingIntent.FLAG_IMMUTABLE)
        notificacion.setContentIntent(pendingIntent)

        notificacion.addAction(R.drawable.ic_launcher_foreground, "Responder", pendingIntent)

        mNotificationManager.notify(NOTIFICATION_ID, notificacion.build())
    }

    private fun crearNotificacionImagenGrande() {
        val notificacion = NotificationCompat.Builder(this, CANAL_ID)
        notificacion
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Imagen Expandible")
            .setContentText("Contenido de la notificación")

        val bigPictureStyle = NotificationCompat.BigPictureStyle()
        bigPictureStyle.bigPicture(BitmapFactory.decodeResource(resources, R.drawable.banner))

        notificacion.setStyle(bigPictureStyle)
        mNotificationManager.notify(NOTIFICATION_ID, notificacion.build())
    }

    private fun crearNotificacionTextoGrande() {
        val notificacion = NotificationCompat.Builder(this, CANAL_ID)
        notificacion
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Titulo comprimido")
            .setContentText("Contenido comprimido de la notificacion")

        val lorem = resources.getString(R.string.notificacion)
        val content = lorem.split("\\.".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val inboxStyle = NotificationCompat.InboxStyle()
        for(line in content) {
            inboxStyle.addLine(line)
        }
        inboxStyle.setBigContentTitle("Titulo Expandido")
        notificacion.setStyle(inboxStyle)

        mNotificationManager.notify(NOTIFICATION_ID, notificacion.build())
    }

    private fun crearNotificacionSimple() {
        val notificacion = NotificationCompat.Builder(this, CANAL_ID)
        notificacion
            .setContentTitle("Titulo de notificacion")
            .setContentText("Este es el texto de la notificacion Este es el texto de la notificacion Este es el texto de la notificacion Este es el texto de la notificacion")
            .setSmallIcon(android.R.drawable.ic_dialog_alert)
            //.setLargeIcon(BitmapFactory.decodeResource(this.resources, android.R.drawable.ic_dialog_email))
            .setSubText("Este es un subtex")
            //.setOngoing(false)  Bloquear la notificacion
            .setAutoCancel(true)

        val intent = Intent(this, ResultadoActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0,
            intent, PendingIntent.FLAG_IMMUTABLE)
        notificacion.setContentIntent(pendingIntent)

        mNotificationManager.notify(NOTIFICATION_ID, notificacion.build())
    }
}