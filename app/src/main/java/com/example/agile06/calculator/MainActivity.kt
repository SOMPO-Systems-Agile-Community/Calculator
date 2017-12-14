package com.example.agile06.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*

// 演算ボタン
enum class Operation {
    NONE, PLUS, MINUS, MUL, DIV
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 電卓上に表示されている数
        var value = 0

        // スタックされている数
        var stack1 = 0
        var stack2 = 0

        // 押された演算ボタン
        var operation = Operation.NONE

        val display = findViewById<TextView>(R.id.textView)
        val btn1 = findViewById<Button>(R.id.button1)
        val btn2 = findViewById<Button>(R.id.button2)
        val btn3 = findViewById<Button>(R.id.button3)
        val btn4 = findViewById<Button>(R.id.button4)
        val btn5 = findViewById<Button>(R.id.button5)
        val btn6 = findViewById<Button>(R.id.button6)
        val btn7 = findViewById<Button>(R.id.button7)
        val btn8 = findViewById<Button>(R.id.button8)
        val btn9 = findViewById<Button>(R.id.button9)
        val btn0 = findViewById<Button>(R.id.button0)
        val btnDot = findViewById<Button>(R.id.buttonDot)
        val btnPlus = findViewById<Button>(R.id.buttonPlus)
        val btnMinus = findViewById<Button>(R.id.buttonMinus)
        val btnDiv = findViewById<Button>(R.id.buttonDiv)
        val btnMul = findViewById<Button>(R.id.buttonMul)
        val btnEqual = findViewById<Button>(R.id.buttonEqual)
        val btnCls = findViewById<Button>(R.id.buttonCls)

        // ボタン０から９は表示されている値を１０倍して入力ボタンの数を足す
        btn1.setOnClickListener {
            value = value * 10 + 1
            textView.text = value.toString()
        }

        btn2.setOnClickListener {
            value = value * 10 + 2
            textView.text = value.toString()
        }

        btn3.setOnClickListener {
            value = value * 10 + 3
            textView.text = value.toString()
        }

        btn4.setOnClickListener {
            value = value * 10 + 4
            textView.text = value.toString()
        }

        btn5.setOnClickListener {
            value = value * 10 + 5
            textView.text = value.toString()
        }

        btn6.setOnClickListener {
            value = value * 10 + 6
            textView.text = value.toString()
        }

        btn7.setOnClickListener {
            value = value * 10 + 7
            textView.text = value.toString()
        }
        btn8.setOnClickListener {
            value = value * 10 + 8
            textView.text = value.toString()
        }
        btn9.setOnClickListener {
            value = value * 10 + 9
            textView.text = value.toString()
        }
        btn0.setOnClickListener {
            value = value * 10 + 0
            textView.text = value.toString()
        }

        // 演算ボタンが押されたら、表示されている数をstack1に退避、押されたボタンをoperationに退避
        btnPlus.setOnClickListener {
            stack1 = value
            operation = Operation.PLUS
            value = 0
        }

        btnEqual.setOnClickListener {
            // operationに応じて演算結果を表示する。
            when (operation) {
                Operation.PLUS -> {
                    value = value + stack1
                    textView.text = value.toString()
                }
            }
        }

        btnCls.setOnClickListener {
            // 全クリア
            operation = Operation.NONE
            value = 0
            stack1 = 0
            stack2 = 0
            textView.text = value.toString()
        }


    }
}
