package com.example.mathgeo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mathgeo.databinding.ActivityMainBinding
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner


class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*Selección de la formula*/

        val SPSeleccion: Spinner = findViewById(R.id.Selector)//(Selector) -> Referencia al Id del spinner
        ArrayAdapter.createFromResource(
            this,
            R.array.Opciones, //Arreglo de nuestras opciones (Rectangulo, rombo, triangulo)
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            SPSeleccion.adapter = adapter
        }

        //¡Importante esta nos deja elegir una cajita
        binding.Selector.onItemSelectedListener = this
    }

    /* Logica para mostrar los diferentes datos en pantalla */
    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {

        val arrayLugar = position.toString().toInt()

        /**** Proceso de selección ****/

        when (arrayLugar) {
            0 -> {
                /*Datos (Imagen, base y altura)*/
                val primerDato = findViewById<EditText>(R.id.editTextNumber)
                primerDato.hint = getString(R.string.Base)
                val segundoDato = findViewById<EditText>(R.id.editTextNumber2)
                segundoDato.hint = getString(R.string.Altura)
                val imagen = findViewById<ImageView>(R.id.imageView)
                imagen.setImageResource(R.drawable.rectangulo)

                /*Manda la orden al botton para obtener el resultado*/
                binding.button.setOnClickListener {
                    val numberA: Double
                    val numberB: Double

                    if ((binding.editTextNumber.text.isEmpty() && binding.editTextNumber2.text.isNotEmpty()) || (binding.editTextNumber.text.isNotEmpty() && binding.editTextNumber2.text.isEmpty())){
                        binding.textView2.text = getString(R.string.faltaUno)

                    }else if (binding.editTextNumber.text.isEmpty() && binding.editTextNumber2.text.isEmpty()){
                        binding.textView2.text = getString(R.string.faltanDos)

                    }else{
                        if (binding.editTextNumber.text.isNotEmpty() && binding.editTextNumber2.text.isNotEmpty()) {
                            numberA = binding.editTextNumber.text.toString().toDouble()
                            numberB = binding.editTextNumber2.text.toString().toDouble()
                            /*Llamada a la función rectangulo*/
                            val area = rectangulo(numberA, numberB)
                            binding.textView2.text = getString(R.string.areaID, area)
                        }
                    }
                }

            }

            1 -> {
                val primerDato = findViewById<EditText>(R.id.editTextNumber)
                primerDato.hint = getString(R.string.Base)
                val segundoDato = findViewById<EditText>(R.id.editTextNumber2)
                segundoDato.hint = getString(R.string.Altura)
                val imagen = findViewById<ImageView>(R.id.imageView)
                imagen.setImageResource(R.drawable.triangulo)

                /*Manda la orden al botton para obtener el resultado*/
                binding.button.setOnClickListener {
                    val numberA: Double
                    val numberB: Double

                    if ((binding.editTextNumber.text.isEmpty() && binding.editTextNumber2.text.isNotEmpty()) || (binding.editTextNumber.text.isNotEmpty() && binding.editTextNumber2.text.isEmpty())){
                        binding.textView2.text = getString(R.string.faltaUno)

                    }else if (binding.editTextNumber.text.isEmpty() && binding.editTextNumber2.text.isEmpty()){
                        binding.textView2.text = getString(R.string.faltanDos)

                    }else {

                        if (binding.editTextNumber.text.isNotEmpty() && binding.editTextNumber2.text.isNotEmpty()) {
                            numberA = binding.editTextNumber.text.toString().toDouble()
                            numberB = binding.editTextNumber2.text.toString().toDouble()
                            val area = triangulo(numberA, numberB)
                            binding.textView2.text = getString(R.string.areaID, area)
                        }
                    }
                }
            }

            else -> {
                val primerDato = findViewById<EditText>(R.id.editTextNumber)
                primerDato.hint = getString(R.string.DMayor)
                val segundoDato = findViewById<EditText>(R.id.editTextNumber2)
                segundoDato.hint = getString(R.string.DMenor)
                val formulaImage = findViewById<ImageView>(R.id.imageView)
                formulaImage.setImageResource(R.drawable.triangulo)

                /*Manda la orden al botton para obtener el resultado*/
                binding.button.setOnClickListener {
                    val numberA: Double
                    val numberB: Double

                    if ((binding.editTextNumber.text.isEmpty() && binding.editTextNumber2.text.isNotEmpty()) || (binding.editTextNumber.text.isNotEmpty() && binding.editTextNumber2.text.isEmpty())){
                        binding.textView2.text = getString(R.string.faltaUno)

                    }else if (binding.editTextNumber.text.isEmpty() && binding.editTextNumber2.text.isEmpty()){
                        binding.textView2.text = getString(R.string.faltanDos)

                    }else {

                        if (binding.editTextNumber.text.isNotEmpty() && binding.editTextNumber2.text.isNotEmpty()) {
                            numberA = binding.editTextNumber.text.toString().toDouble()
                            numberB = binding.editTextNumber2.text.toString().toDouble()
                            val area = triangulo(numberA, numberB)
                            binding.textView2.text = getString(R.string.areaID, area)
                        }
                    }
                }

            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
    private fun rectangulo(numero1: Double, numero2: Double): Double {
        return numero1*numero2
    }

    private fun triangulo(numero1: Double, numero2: Double): Double {
        return (numero1*numero2)/2
    }
}