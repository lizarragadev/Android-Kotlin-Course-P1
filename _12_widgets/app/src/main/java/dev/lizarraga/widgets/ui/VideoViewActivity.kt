package dev.lizarraga.widgets.ui

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import dev.lizarraga.widgets.R
import dev.lizarraga.widgets.databinding.ActivityVideoViewBinding

class VideoViewActivity : AppCompatActivity() {
    lateinit var binding: ActivityVideoViewBinding
    var mediaControls: MediaController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(mediaControls == null) {
            mediaControls = MediaController(this)
            mediaControls?.setAnchorView(binding.vvVideo)
        }
        binding.vvVideo.setMediaController(mediaControls)
        binding.vvVideo.setVideoURI(Uri.parse("android.resource://$packageName/${R.raw.video}"))
        binding.vvVideo.requestFocus()
        binding.vvVideo.start()

        binding.vvVideo.setOnCompletionListener {
            finish()
        }
    }
}