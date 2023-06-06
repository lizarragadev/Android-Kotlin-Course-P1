package k_05_estructurasCiclicas

fun main() {
    var cPar = 0
    var cImpar = 0
    for(i in 100 downTo 1 step 2) {
        print("$i, ")
        if(i % 2 == 0 )
            cPar++
        else
            cImpar++
    }
    println("\nCantidad de pares: $cPar")
    println("Cantidad de impares: $cImpar")
}