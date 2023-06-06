package k_04_estructuraWhen

fun main() {
    var cant1_3 = 0
    var cant2_4 = 0
    var cantX = 0
    for(i in 1..10) {
        print("Ingrese un número: ")
        val num = readln().toInt()
        when(num) {
            1, 3 -> cant1_3++
            2, 4 -> cant2_4++
            else -> cantX++
        }
    }
    println("Cantidad de 1 y 3: $cant1_3")
    println("Cantidad de 2 y 4: $cant2_4")
    println("Cantidad de X: $cantX")
}