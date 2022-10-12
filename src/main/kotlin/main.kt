import kotlin.math.max
import kotlin.math.roundToInt

fun main() {
    calcCommission(10_000)
    calcCommission(10_000, card = "Mastercard")
    calcCommission(10_000, 100_000,"Maestro")
    calcCommission(10_000, card = "Visa")
    calcCommission(1_000, 100_000,"Мир")
}

fun calcCommission(amount: Int, current: Int = 0, card: String = "Vk Pay"): Int {
    var commission: Int = when (card) {
        "Vk Pay" -> 0
        "Visa", "Мир" -> {
            max((amount * 0.0075f).roundToInt(), 35)
        }
        "Mastercard", "Maestro" -> {
            if (current <= 75_000) 0 else 20 + (amount * 0.006f).roundToInt()
        }
        else -> {
            println("Unknown card '$card'")
            0   // Let it be
        }
    }

    println("$card: transfer $amount RUB with commission $commission RUB")
    return commission
}
