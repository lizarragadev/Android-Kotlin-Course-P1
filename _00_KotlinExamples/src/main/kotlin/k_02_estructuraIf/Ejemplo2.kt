package k_02_estructuraIf

fun main() {
    print("Ingrese un valor: ")
    val a = readln().toInt()
    val resultado = if(a % 2 == 0) {
        println("Cuadrado")
        a * a
    } else {
        println("Cubo")
        a * a * a
    }
    println("El resultado es: $resultado")
}