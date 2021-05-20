package com.example.capitnrot

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener


class MainActivity : AppCompatActivity() {

    private var angleBar: SeekBar? = null
    private var editText: EditText? = null
    private var angleLabel: TextView? = null
    private var angleValue: TextView? = null
    private var buttonNext: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editableText)
        editText?.addTextChangedListener {
            if (true == it?.firstOrNull()?.isUpperCase()) {
                showAngleViews(true)
            } else {
                handleBadText()
            }
        }

        angleLabel = findViewById(R.id.angleLabel)
        angleBar = findViewById(R.id.angleBar)
        angleValue = findViewById(R.id.angleValue)
        angleBar?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    setAngle(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
        buttonNext = findViewById(R.id.buttonNext)

        setAngle(angleBar?.progress ?: 0)
    }

    private fun setAngle(progress: Int) {
        angleValue?.text = "$progress"
    }

    private fun showAngleViews(show:Boolean) {
        val visiblilty =  if (show) View.VISIBLE else View.INVISIBLE
        angleLabel?.visibility = visiblilty
        angleBar?.visibility = visiblilty
        angleValue?.visibility = visiblilty
        buttonNext?.visibility = visiblilty
    }

    private fun handleBadText() {
        showMessage(R.string.bad_text)
        showAngleViews(false)
    }

    private fun showMessage(string: Int) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
    }

    fun applyAngle(view: View) {
        val intent = Intent(this, RotateActivity::class.java).apply {
            putExtra(EXTRA_ANGLE, angleBar?.progress ?: 0)
        }
        startActivity(intent)
    }

    companion object {
        const val EXTRA_ANGLE = "com.example.capitnrot.ANGLE"
    }
}
