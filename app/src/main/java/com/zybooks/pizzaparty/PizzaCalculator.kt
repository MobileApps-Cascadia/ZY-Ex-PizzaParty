package com.zybooks.pizzaparty

import kotlin.math.ceil


class PizzaCalculator(partySize: Int, var hungerLevel: HungerLevel, var sizeOfPizza: SizeOfPizza) {
    var partySize = 0
        set(value) {
            field = if (value >= 0) value else 0
        }

    enum class HungerLevel(var numSlices: Int) {
        LIGHT(2), MEDIUM(3), RAVENOUS(4)
    }

    enum class SizeOfPizza(var numSlicesPerSize: Int){
        SMALL(6), MEDIUM(8), LARGE(12)
    }

    val totalPizzas: Int
        get() {
            return ceil(partySize * hungerLevel.numSlices / sizeOfPizza.numSlicesPerSize.toDouble()).toInt()
        }

    init {
        this.partySize = partySize
    }
}