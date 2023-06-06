package k_01_tiposDeDatoYEntradaPorTeclado

/*
* VAR: Variable mutable
* VAL: Variable inmutable *USAR MAS*
* */
val x: Int = 4
val y = 6
// var se reservan 2 espacios de memoria
// val se reserva 1 espacio de memoria
fun main() {
    var resultado = x.plus(y)
    println("La suma es: $resultado")
    resultado = x.minus(y)
    println("La resta es: $resultado")
    resultado = x.times(y)
    println("La multiplicación es: $resultado")
    resultado = x.div(y)
    println("La división es: $resultado")
}