package k_06_funciones

fun main() {
    val suma = { n1: Int, n2: Int -> n1 + n2 }
    println("${suma(3, 6)}")
}