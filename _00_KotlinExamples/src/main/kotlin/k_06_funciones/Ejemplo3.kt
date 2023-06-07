package k_06_funciones

fun main() {
    print("Ingrese el primer número: ")
    val n1 = readln().toInt()
    print("Ingrese el segundo número: ")
    val n2 = readln().toInt()
    println("El mayor es: ${retornaMayor(n1, n2)}")
}

fun retornaMayor(n1: Int, n2: Int) = if(n1 > n2) n1 else n2
