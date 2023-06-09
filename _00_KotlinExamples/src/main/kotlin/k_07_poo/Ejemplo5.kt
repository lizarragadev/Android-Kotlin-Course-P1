package k_07_poo

abstract class Vehiculo {
    abstract fun acelerar()
    abstract fun detener()
    fun frenar() {
        println("Frenando...")
    }
}
class Auto: Vehiculo() {
    override fun acelerar() {
        println("Acelerando...")
    }

    override fun detener() {
        println("El auto se detuvo.")
    }
}

fun main() {
    val auto = Auto()
    auto.acelerar()
    auto.frenar()
    auto.detener()
}