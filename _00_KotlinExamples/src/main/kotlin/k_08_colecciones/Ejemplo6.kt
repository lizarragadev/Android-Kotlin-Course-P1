package k_08_colecciones

// Sets
fun main() {
    val conjunto = mutableSetOf(1, 2, 2, 2, 2, 6, 7, 8, 9)
    println("Conjunto original")
    println(conjunto)
    if(86 in conjunto) {
        println("El 6 está en el conjunto")
    } else {
        println("El 6 no está en el conjunto")
    }
    val suma = conjunto.sum()
    println("La suma de los elementos del conjunto es $suma")

    val suma2 = conjunto.count { it > 7 }
    println("La suma de los elementos mayores a 7 es $suma2")

}