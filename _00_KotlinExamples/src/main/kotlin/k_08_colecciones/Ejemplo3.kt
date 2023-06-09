package k_08_colecciones

fun main() {
    val lista1: List<Int> = List(5){ cargarLista() }
    println(lista1)
}

fun cargarLista(): Int {
    print("Ingrese un número: ")
    return readln().toInt()
}