package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var text1:TextView
    private var operation  = " "
    private var operand1 = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        text1 = findViewById(R.id.textView)






    }

    fun onclick(clickedview: View) {
        if (clickedview is TextView){
            val number = clickedview.text.toString()
            var text = text1.text.toString()

            if (text == "0"){
                text = ""
            }
            text1.text = text + number

        }


    }

    fun operationClick(clickedview: View) {
        if (clickedview is TextView){
            operation = clickedview.text.toString()

            operand1 = text1.text.toString().toDouble()
            text1.text = "0"
        }

    }

    fun equalsClick() {

        val operand2 = text1.text.toString().toDouble()
        if (operation == " "){
            text1.text = text1.text.toString()
        }else {
            when (operation) {

                "+" -> text1.text = (operand1 + operand2).toString()
                "-" -> text1.text = (operand1 - operand2).toString()
                "*" -> text1.text = (operand1 * operand2).toString()
                "/" -> text1.text = (operand1 / operand2).toString()

            }
            operation = " "
            operand1
            val newnumber = text1.text.toString()
            if (newnumber.substring(newnumber.length - 2, newnumber.length) == ".0") {
                text1.text = newnumber.substring(0, newnumber.length - 2)
            }
        }

    }

    fun cleartxt() {
        text1.text = "0"
        operand1 = 0.0
    }

    fun delete() {
        val newoperand1 = operand1.toString().substring(0,operand1.toString().length-2)

        val txt = text1.text.toString()

        if (txt.length == 1 && operand1 ==0.0) {
            text1.text = "0"
        }else if (txt.length == 1){
            text1.text = newoperand1
            operand1 = 0.0


        }else {
            text1.text = txt.substring(0, txt.length - 1)
        }
    }

    fun dotclick() {
        var dotexists = false
        val txt = text1.text.toString()
        for (i in 0 until txt.length  ){
            if (txt[i]=='.'){
                dotexists = true
            }
        }
        if (dotexists == false){
            text1.text = txt + '.'
        }

    }


}



