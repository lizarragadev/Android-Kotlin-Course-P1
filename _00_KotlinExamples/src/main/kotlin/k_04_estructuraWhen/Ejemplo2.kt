package k_04_estructuraWhen

fun main() {
    val nota1 = 67
    val nota2 = 89
    val nota3 = 45
    val promedio = (nota1 + nota2 + nota3) / 3
    when {
        promedio >= 70 -> println("El promedio es $promedio, BUENO")
        promedio <= 40 -> println("El promedio es $promedio, DEFICIENTE")
        else -> println("El promedio es $promedio, REGULAR")
    }
}