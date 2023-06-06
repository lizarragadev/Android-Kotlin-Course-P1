package k_04_estructuraWhen

fun main() {
    var cant1 = 0
    var cant2 = 0
    var cant3 = 0
    do {
        print("Ingrese el peso de la pieza (0 para finalizar)")
        val peso = readln().toDouble()
        when {
            peso > 10.2 && peso < 11.0 -> cant1++
            peso > 8.2 || peso < 9.9 -> cant2++
            else -> cant3++
        }
    } while (peso != 0.0)
    println("Cantidad de piezas aptas para la venta: $cant1")
    println("Cantidad de piezas aptas para la venta: $cant2")
    println("Cantidad de piezas aptas para la venta: $cant3")
}