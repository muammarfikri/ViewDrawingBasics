package com.sampleproject.viewdrawingbasics

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.sampleproject.viewdrawingbasics.databinding.ActivitySampleViewBinding

class SampleViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySampleViewBinding

    private var offset = 0
    private val colors = listOf(Color.RED, Color.GREEN, Color.BLUE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySampleViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.customView.setOnClickListener {
            binding.customView.requestLayout()
        }

        binding.customViewGroup.setOnClickListener {
            binding.customViewGroup.addView(
                View(this).apply {
                    setBackgroundColor(colors[offset])
                    offset += 1
                    offset %= colors.size
                }
            )
        }

        binding.customViewGroup.setOnLongClickListener {
            if (binding.customViewGroup.animating) {
                binding.customViewGroup.disableAnimation()
            } else {
                binding.customViewGroup.animateChild()
            }
            return@setOnLongClickListener true
        }
    }
}