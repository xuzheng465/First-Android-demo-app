package com.example.berkeley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    private var points = 0
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pickRandomNumbers()
    }

    fun leftButtonClick(view: View) {
        val leftButton = findViewById<Button>(R.id.left_button)
        val rightButton = findViewById<Button>(R.id.right_button)
        val leftNum = leftButton.text.toString().toInt()
        val rightNum = rightButton.text.toString().toInt()
        if(leftNum>rightNum) {
            points++
        } else {
            if(points!=0)
                points--
        }
        findViewById<TextView>(R.id.points).text = "Points: $points"
        pickRandomNumbers()
    }

    fun rightButtonClick(view: View) {

        val leftButton = findViewById<Button>(R.id.left_button)
        val rightButton = findViewById<Button>(R.id.right_button)
        val leftNum = leftButton.text.toString().toInt()
        val rightNum = rightButton.text.toString().toInt()
        if(leftNum<=rightNum) {
            points++
        } else {
            if(points!=0)
                points--
        }
        findViewById<TextView>(R.id.points).text = "Points: $points"
        pickRandomNumbers()
    }

    private fun pickRandomNumbers() {
        val leftButton = findViewById<Button>(R.id.left_button)
        val left_r = Random()
        val left_num = left_r.nextInt(10)
        leftButton.text = "$left_num"
        val lefButton = findViewById<Button>(R.id.right_button)
        val right_r = Random()
        val num = right_r.nextInt(10)
        lefButton.text = "$num"
    }
}
