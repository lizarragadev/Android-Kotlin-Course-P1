package k_06_funciones

fun main() {
    multiplo2y5()
}

fun multiplo2y5() {
    var mult2 = 0
    var mult5 = 0
    // Función local
    fun multiplo(valor: Int, multiplo: Int) = valor % multiplo == 0

    for(i in 1..10) {
        print("Ingrese valor: ")
        var valor = readln().toInt()
        if(multiplo(valor, 2)) mult2++
        if(multiplo(valor, 5)) mult5++
    }
    println("Cantidad de múltiplos de 2: $mult2")
    println("Cantidad de múltiplos de 5: $mult5")
}