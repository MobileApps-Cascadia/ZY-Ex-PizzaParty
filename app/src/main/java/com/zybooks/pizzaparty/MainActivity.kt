package com.zybooks.pizzaparty

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    private lateinit var numAttendEditText: EditText
    private lateinit var numPizzasTextView: TextView
    private lateinit var howHungryRadioGroup: RadioGroup
    private lateinit var pizzaSizeRadioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Access to the UI View objects
        numAttendEditText = findViewById(R.id.num_attend_edit_text)
        numPizzasTextView = findViewById(R.id.num_pizzas_text_view)
        howHungryRadioGroup = findViewById(R.id.hungry_radio_group)
        pizzaSizeRadioGroup = findViewById(R.id.pizza_size_radio_group)
        numPizzasTextView.setText("")
    }

    fun calculateClick(view: View) {
        // Get the number of people from the UI (as an Int)
        val numAttendStr = numAttendEditText.text.toString()
        val numAttend = numAttendStr.toIntOrNull() ?: 0 //Fixes app crash by providing a default value if null

        // Get hunger level selection
        val hungerLevel = when (howHungryRadioGroup.getCheckedRadioButtonId()) {
            R.id.light_radio_button -> PizzaCalculator.HungerLevel.LIGHT
            R.id.medium_radio_button -> PizzaCalculator.HungerLevel.MEDIUM
            else -> PizzaCalculator.HungerLevel.RAVENOUS
        }
        // Get pizza size selection
        val pizzaSize = when (pizzaSizeRadioGroup.getCheckedRadioButtonId()) {
            R.id.small_radio_button -> PizzaCalculator.PizzaSize.SMALL
            R.id.smedium_radio_button -> PizzaCalculator.PizzaSize.MEDIUM
            else -> PizzaCalculator.PizzaSize.LARGE
        }
        // Get the number of pizzas needed using the Model: Pizza Calculator
        val calculator = PizzaCalculator(numAttend,hungerLevel,pizzaSize)
        val totalPizzas = calculator.totalPizzas

        // Place totalPizzas into the string resource and display
        val totalText = getString(R.string.total_pizzas,totalPizzas)
        numPizzasTextView.setText(totalText)
    }
}