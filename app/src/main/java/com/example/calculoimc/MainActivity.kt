package com.example.calculoimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var editPeso: EditText
    lateinit var editAltura: EditText
    lateinit var btnCalcular: Button
    lateinit var textResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editPeso = findViewById(R.id.editPeso)
        editAltura = findViewById(R.id.editAltura)
        btnCalcular = findViewById(R.id.button)
        textResultado = findViewById(R.id.resultado)

        btnCalcular.setOnClickListener {
            calcularIMC()
        }
    }

    fun calcularIMC() {
        val pesoStr = editPeso.text.toString()
        val alturaStr = editAltura.text.toString()

        if (pesoStr.isNotEmpty() && alturaStr.isNotEmpty()) {
            val peso = pesoStr.toFloat()
            val altura = alturaStr.toFloat()

            val imc = peso / (altura * altura)

            val resultado = when {
                imc < 18.5 -> {
                    val intent = Intent(this, AbaixoActivity::class.java)
                    startActivity(intent)
                }
                imc < 24.9 -> {
                    val intent = Intent(this, NormalActivity::class.java)
                    startActivity(intent)
                }
                imc < 29.9 -> {
                    val intent = Intent(this, SobrepesoActivity::class.java)
                    startActivity(intent)
                }
                imc < 34.9 -> {
                    val intent = Intent(this, Grau1Activity::class.java)
                    startActivity(intent)
                }
                imc < 39.9 -> {
                    val intent = Intent(this, Grau2Activity::class.java)
                    startActivity(intent)
                }
                else -> {
                    val intent = Intent(this, Grau3Activity::class.java)
                    startActivity(intent)
                }
            }

        } else {
            textResultado.text = "Preencha o peso e a altura."
        }
    }
}
