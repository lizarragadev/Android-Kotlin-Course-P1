package k_01_tiposDeDatoYEntradaPorTeclado

fun main() {
    print("Ingrese número 1: ")
    val num1 = readln().toInt()
    print("Ingrese número 2: ")
    val num2 = readln().toInt()
    println("La suma es: ${num1.plus(num2)}")
    println("La resta es: ${num1.minus(num2)}")
    println("La multiplicación es: ${num1.times(num2)}")
    println("La división es: ${num1.div(num2)}")
}