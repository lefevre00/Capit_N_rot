package com.example.capitnrot

import android.R.attr
import android.graphics.Matrix
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class RotateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rotate)

        val angle = intent.getIntExtra(MainActivity.EXTRA_ANGLE, 0)
        Log.v("ANGLE", "received: $angle")
        findViewById<ImageView>(R.id.imageView).apply {
            this.rotation = angle.toFloat()
//            val matrix = Matrix()
//            this.scaleType = ImageView.ScaleType.MATRIX

//            val bounds = this.drawable.bounds
//            matrix.postRotate( angle?.toFloat() ?: 0f, bounds.width()/2.toFloat(), bounds.height()/2.toFloat());
//            matrix.postRotate( 180f, bounds.width()/2.toFloat(), bounds.height()/2.toFloat());
//            this.imageMatrix = matrix

        }

    }

}
