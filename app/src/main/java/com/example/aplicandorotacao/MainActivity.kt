package com.example.aplicandorotacao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var textView: TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text1 = savedInstanceState?.getString("Text_View1") ?: "0"
        Log.d("teste", "Restaurando $text1")
        var count = Integer.parseInt(text1)

        val button1 = findViewById<Button>(R.id.buttonPlus1)
        val button2 = findViewById<Button>(R.id.buttonRemove)
        textView?.text = count.toString()

        button1.setOnClickListener {
            count += 1
            textView?.text = count.toString()
        }
        button2.setOnClickListener {
            count -= 1
            textView?.text = count.toString()
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val text = textView?.text.toString()
        Log.d("teste", "Salvando $text")
        outState.putString("Text_View1", text)


    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("teste", "Destruindo app")
    }
}