package k_09_nulos

fun main() {
    var nombre: String? = null

    var x: Int? = null

    // Expresion de acceso seguro ( ? )
    val y = x?.toDouble()
    println(y)

    // Operador Elvis ( ?: )
    val y1 = x?.toDouble() ?: 0.0
    println(y1)

    // Operador mala práctica ( !! )
    val y2 = x!!.toDouble()
    println(y2)
}