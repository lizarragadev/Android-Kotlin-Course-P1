package k_08_colecciones

fun main() {
    val lista = listOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes")
    println("Imprimir la lista completa")
    println(lista)
    println("Imprimir el primer elemento de la lista")
    println(lista[0])
    println("Imprimir el primer elemento de la lista con Kotlin")
    println(lista.first())
    println("Imprimir el último elemento de la lista")
    println(lista[lista.size - 1])
    println("Imprimir el último elemento de la lista con Kotlin")
    println(lista.last())
    for(elemento in lista) {
        println(elemento)
    }
    println("Imprimir la lista con índices")
    for(posicion in lista.indices) {
        println("${posicion + 1} | ${lista[posicion]}")
    }
}