package com.example.capitnrot

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class RotateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rotate)

        val angle = intent.getIntExtra(MainActivity.EXTRA_ANGLE, 0)
        Log.v("ANGLE", "received: $angle")
        findViewById<ImageView>(R.id.imageView).apply {
            this.rotation = angle.toFloat()
        }
    }

}
