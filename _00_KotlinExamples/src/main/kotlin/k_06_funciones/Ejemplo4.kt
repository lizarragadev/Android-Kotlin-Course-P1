package k_06_funciones

fun main() {
    for(i in 1..10)
        print("${convertirLiteral(i)}, ")
}

fun convertirLiteral(num: Int) = when(num) {
        1 -> "Uno"
        2 -> "Dos"
        3 -> "Tres"
        4 -> "Cuatro"
        5 -> "Cinco"
        6 -> "Seis"
        7 -> "Siete"
        8 -> "Ocho"
        9 -> "Nueve"
        10 -> "Diez"
        else -> "Número no soportado"
    }
