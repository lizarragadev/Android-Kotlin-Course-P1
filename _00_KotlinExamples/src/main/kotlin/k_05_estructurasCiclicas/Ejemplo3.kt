package k_05_estructurasCiclicas

fun main() {
    print("Cuantas veces ingresara: ")
    val n = readln().toInt()
    var x = 1
    do {
        val lee = readln().toInt()
        println("El numero es: $lee")
        x = x.plus(1)
    } while(x <= n)
}