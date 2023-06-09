package k_08_colecciones

fun main() {
    // Puede reemplazarse por mutableMapOf
    val paises = mapOf(
        Pair("argentina", 4000),
        Pair("bolivia", 5000),
        Pair("colombia", 3222)
    )
    println(paises)
    for((clave, valor) in paises) {
        println("Para la clave $clave el valor es $valor")
    }
}