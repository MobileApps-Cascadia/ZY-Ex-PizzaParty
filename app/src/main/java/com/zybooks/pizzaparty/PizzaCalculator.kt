package com.zybooks.pizzaparty

import android.util.Size
import kotlin.math.ceil

// const val SLICES_PER_PIZZA = 8

class PizzaCalculator(partySize: Int, var hungerLevel: HungerLevel, var pizzaSize: PizzaSize) {
    var partySize = 0
        set(value) {
            field = if (value >= 0) value else 0
        }

    enum class HungerLevel(var numSlices: Int) {
        LIGHT(2), MEDIUM(3), RAVENOUS(4)
    }

    enum class PizzaSize(var numSlices: Int) {
        SMALL(6), MEDIUM(8), LARGE(12)
    }

    val totalPizzas: Int
        get() {
            return ceil((partySize * hungerLevel.numSlices) / pizzaSize.numSlices.toDouble()).toInt()
        }

    init {
        this.partySize = partySize
    }
}