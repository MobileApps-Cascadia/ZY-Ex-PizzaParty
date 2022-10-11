package com.zybooks.pizzaparty

import kotlin.math.ceil

//const val SLICES_PER_PIZZA = 8

class PizzaCalculator(partySize: Int, var hungerLevel: HungerLevel, var pisize: SlicesPerPizza) {
    var partySize = 0
        set(value) {
            field = if (value >= 0) value else 0
        }

    enum class HungerLevel(var numSlices: Int) {
        LIGHT(2), MEDIUM(3), RAVENOUS(4)
    }
    enum class SlicesPerPizza(var pisize: Int) {
        Small(6), Medium(8), Large(12)
    }
    val totalPizzas: Int
        get() {
            return ceil(partySize * hungerLevel.numSlices/ pisize.pisize.toDouble()).toInt()
        }

    init {
        this.partySize = partySize
    }
}