package k_08_colecciones

fun main() {
    val edades = mutableListOf(34, true, 22, "Hola", 23, 10.5, 'a')
    println("Lista original")
    println(edades)
    edades[0] = 35
    println(edades)
}