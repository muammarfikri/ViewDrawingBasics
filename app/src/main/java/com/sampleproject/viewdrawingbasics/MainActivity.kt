package com.sampleproject.viewdrawingbasics

import android.animation.Animator
import android.animation.ValueAnimator
import android.content.Context
import android.content.Intent
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginTop
import com.sampleproject.viewdrawingbasics.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSampleView.setOnClickListener {
            startActivity(Intent(this, SampleViewActivity::class.java))
        }
        binding.buttonPaintDrawing.setOnClickListener {
            startActivity(Intent(this, PaintDrawingActivity::class.java))
        }
        binding.buttonGame.setOnClickListener {
            startActivity(Intent(this, TouchGameActivity::class.java))
        }

    }
}
