package dev.lizarraga.widgets.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.lizarraga.widgets.R
import dev.lizarraga.widgets.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {
    lateinit var binding: ActivityWebViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}