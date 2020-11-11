package com.example.zekalkulatori

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView

    private var operand:Double=0.0
    private var operation:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView=findViewById(R.id.resultTextView)

        findViewById<TextView>(R.id.clearButton).setOnClickListener{
            operand = 0.0
            operation = ""
            resultTextView.text= ""
        }
    }
    fun numberclick(view:View) {

        if (view is TextView) {
            val number: String=view.text.toString()
            var result: String=resultTextView.text.toString()

           if (result== "0") {
               result == ""
           }
            resultTextView.text = result+number

        }

    }
fun operationClick(view: View){
    if (view is TextView){

        if (!TextUtils.isEmpty(resultTextView.text)){
            operand = resultTextView.text.toString().toDouble()

        }
        resultTextView.text = ""
        operation =view.text.toString()
    }
}
    fun equalsClick(view: View) {
        val secondOperand: String = resultTextView.text.toString()
        var secOperand: Double = 0.0

        if(!TextUtils.isEmpty(secondOperand)) {
            secOperand = secondOperand.toDouble()
        }

        when (operation){
            "+" -> resultTextView.text =(operand + secOperand).toString()
            "-" -> resultTextView.text =(operand - secOperand).toString()
            "x" -> resultTextView.text =(operand * secOperand).toString()
            "÷" -> resultTextView.text =(operand / secOperand).toString()

        }
        findViewById<TextView>(R.id.del).setOnClickListener{
            val del = resultTextView.text.toString()
            resultTextView.text = del.dropLast(1)
        }


        }
    }

