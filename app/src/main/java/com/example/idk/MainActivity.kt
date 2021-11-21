package com.example.idk

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity: AppCompatActivity(),View.OnClickListener{


    private lateinit var button1:Button
    private lateinit var button2:Button
    private lateinit var button3:Button
    private lateinit var button4:Button
    private lateinit var button5:Button
    private lateinit var button6:Button
    private lateinit var button7:Button
    private lateinit var button8:Button
    private lateinit var button9:Button
    private lateinit var resetButton:Button
    private lateinit var scoreFirst:TextView
    private lateinit var scoreSecond:TextView

    private var activePlayer = 1

    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()

    var first = 0
    var second = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        resetButton = findViewById(R.id.resetButton)
        scoreFirst = findViewById(R.id.scoreFirst)
        scoreSecond = findViewById(R.id.scoreSecond)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)

        resetButton.setOnClickListener{
            firstPlayer.clear()
            secondPlayer.clear()
            activePlayer = 1
            button1.text = ""
            button1.setBackgroundColor(Color.BLUE)
            button1.isEnabled = true
            button2.text = ""
            button2.setBackgroundColor(Color.BLUE)
            button2.isEnabled = true
            button3.text = ""
            button3.setBackgroundColor(Color.BLUE)
            button3.isEnabled = true
            button4.text = ""
            button4.setBackgroundColor(Color.BLUE)
            button4.isEnabled = true
            button5.text = ""
            button5.setBackgroundColor(Color.BLUE)
            button5.isEnabled = true
            button6.text = ""
            button6.setBackgroundColor(Color.BLUE)
            button6.isEnabled = true
            button7.text = ""
            button7.setBackgroundColor(Color.BLUE)
            button7.isEnabled = true
            button8.text = ""
            button8.setBackgroundColor(Color.BLUE)
            button8.isEnabled = true
            button9.text = ""
            button9.setBackgroundColor(Color.BLUE)
            button9.isEnabled = true
        }
    }

    override fun onClick(clickedView: View?) {

        if (clickedView is Button){

            var buttonNumb = 0

            when(clickedView.id){
                R.id.button1 -> buttonNumb = 1
                R.id.button2 -> buttonNumb = 2
                R.id.button3 -> buttonNumb = 3
                R.id.button4 -> buttonNumb = 4
                R.id.button5 -> buttonNumb = 5
                R.id.button6 -> buttonNumb = 6
                R.id.button7 -> buttonNumb = 7
                R.id.button8 -> buttonNumb = 8
                R.id.button9 -> buttonNumb = 9
            }

            if (buttonNumb != 0){
                playGame(clickedView, buttonNumb)
            }
        }

    }

    private fun playGame(clickedView: Button, buttonNumb: Int) {

        if (activePlayer == 1){
            activePlayer = 2
            clickedView.text = "x"
            clickedView.setBackgroundColor(Color.GREEN)
            firstPlayer.add(buttonNumb)
        }else {
            activePlayer = 1
            clickedView.text = "0"
            clickedView.setBackgroundColor(Color.YELLOW)
            secondPlayer.add(buttonNumb)
        }
        clickedView.isEnabled = false
        check()
    }


    private fun disableButtons(){
        button1.isEnabled = false
        button2.isEnabled = false
        button3.isEnabled = false
        button4.isEnabled = false
        button5.isEnabled = false
        button6.isEnabled = false
        button7.isEnabled = false
        button8.isEnabled = false
        button9.isEnabled = false
    }

    private fun check(){
        var winner = 0

        if(firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)){
            winner = 1
        }

        if(secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)){
            winner = 2
        }

        if(firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)){
            winner = 1
        }

        if(secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)){
            winner = 2
        }

        if(firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)){
            winner = 1
        }

        if(secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)){
            winner = 2
        }

        if(firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)){
            winner = 1
        }

        if(secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)){
            winner = 2
        }

        if(firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)){
            winner = 1
        }

        if(secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)) {
            winner = 2
        }

        if(firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)){
            winner = 1
        }

        if(secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)){
            winner = 2
        }

        if(firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)){
            winner = 1
        }

        if(secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)){
            winner = 2
        }

        if(firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)){
            winner = 1
        }

        if(secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)){
            winner = 2

        }

        if (winner == 1){
            first ++
            scoreFirst.text = first.toString()
            disableButtons()
            Toast.makeText(this,"the winner is first player",Toast.LENGTH_SHORT).show()

        }else if (winner == 2){
            second ++
            scoreSecond.text = second.toString()
            disableButtons()
            Toast.makeText(this,"the winner is second player",Toast.LENGTH_SHORT).show()
        }
    }
}
