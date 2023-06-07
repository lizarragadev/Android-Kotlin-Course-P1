package k_06_funciones

fun main() {
    print("Ingrese el lado del cuadrado: ")
    val lado = readln().toInt()
    print("El área del cuadrado es: ${retornarSuperficie(lado)}")
}

fun retornarSuperficie(lado: Int): Int {
    return lado.times(lado)
}