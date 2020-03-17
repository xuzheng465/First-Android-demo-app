package com.example.berkeley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private var points = 0
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pickRandomNumbers()
    }

    private fun checkIfCorrectAnswer(isLeft: Boolean) {
        val leftButton = findViewById<Button>(R.id.left_button)
        val rightButton = findViewById<Button>(R.id.right_button)
        val leftNum = leftButton.text.toString().toInt()
        val rightNum = rightButton.text.toString().toInt()
        if(isLeft && leftNum>rightNum || !isLeft && leftNum<rightNum) {
            points++
            Toast.makeText(this, "Good Job",Toast.LENGTH_SHORT).show()
        } else {
            if(points!=0)
                points--
            Toast.makeText(this, "Try Again",Toast.LENGTH_SHORT).show()
        }
        findViewById<TextView>(R.id.points).text = "Points: $points"
    }

    fun leftButtonClick(view: View) {
        checkIfCorrectAnswer(isLeft = true)
        pickRandomNumbers()
    }

    fun rightButtonClick(view: View) {
        checkIfCorrectAnswer(isLeft=false)
        pickRandomNumbers()
    }

    private fun pickRandomNumbers() {
        val leftButton = findViewById<Button>(R.id.left_button)
        val left_r = Random()
        val left_num = left_r.nextInt(10)
        leftButton.text = "$left_num"
        val lefButton = findViewById<Button>(R.id.right_button)
        val right_r = Random()
        var num = right_r.nextInt(10)
        while(left_num==num) num=right_r.nextInt(10)
        lefButton.text = "$num"
    }
}
