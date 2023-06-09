package k_07_poo

interface Figura {
    fun calcularArea(): Double
    fun calcularPerimetro(): Double
}

class Cuadrado(val lado: Double): Figura {
    override fun calcularArea() = lado * lado
    override fun calcularPerimetro() = lado * 4
}

fun main() {
    val cuadrado = Cuadrado(5.0)
    println("El área del cuadrado es: ${cuadrado.calcularArea()}")
    println("El perímetro del cuadrado es: ${cuadrado.calcularPerimetro()}")
}