package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun btn_Click(view: View) {
        if (newOperator){
            dataView.setText("")
        }
        newOperator=false
        var btnSelect = view as Button
        var btnClickValue:String = dataView.text.toString()
        when(btnSelect.id){
            btn_Zero.id->{
                btnClickValue+="0"
            }
            btn_One.id->{
                btnClickValue+="1"
            }
            btn_Two.id->{
                btnClickValue+="2"
            }
            btn_Three.id->{
                btnClickValue+="3"
            }
            btn_Four.id->{
                btnClickValue+="4"
            }
            btn_Five.id->{
                btnClickValue+="5"
            }
            btn_Six.id->{
                btnClickValue+="6"
            }
            btn_Seven.id->{
                btnClickValue+="7"
            }
            btn_Eight.id->{
                btnClickValue+="8"
            }
            btn_Nine.id->{
                btnClickValue+="9"
            }

            btn_Sub.id->{
                btnClickValue="-"+btnClickValue
            }
        }
        dataView.setText(btnClickValue)
    }
    var operator = "*"
    var oldCount=""
    var newOperator=true
    fun btn_Operator(view: View) {
        var btn_Select= view as Button
        when(btn_Select.id){
            btn_Div.id->{
                operator="/"
            }
            btn_Mul.id->{
                operator="*"
            }
            btn_Sub.id->{
                operator="-"
            }
            btn_Sum.id->{
                operator="+"
            }
        }
        oldCount=dataView.text.toString()
        newOperator=true
    }
    fun Equals(view: View) {
        var newCount=dataView.text.toString()
        var result:Double?=null
        when(operator){
            "/"->{
                result=oldCount.toDouble()/newCount.toDouble()
            }
            "*"->{
                result=oldCount.toDouble()*newCount.toDouble()
            }
            "-"->{
                result=oldCount.toDouble()-newCount.toDouble()
            }
            "+"->{
                result=oldCount.toDouble()+newCount.toDouble()
            }
        }
        dataView.setText(result.toString())
        newOperator=true

    }
    fun Ac(view: View) {
        dataView.setText("0")
        newOperator=true
    }
    fun Per(view: View) {
        //sayi veri tipini double yaptık , edit textin ilk stringe sonra double cevirdik ve 100 e bolduk
        var count:Double=dataView.text.toString().toDouble()/100
        dataView.setText(count.toString())
        newOperator=true
    }

}