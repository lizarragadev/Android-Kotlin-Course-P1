package k_07_poo

class Caja<T>(val contenido: T) {
    fun obtenerContenido(): T{
        return contenido
    }
}
fun main() {
    val caja1 = Caja(true)
    val caja2 = Caja(3.1416)
    val caja3 = Caja("Hola mundo")
    val caja4 = Caja(3)

    println("Contenido de la caja 1: ${caja1.obtenerContenido()}")
    println("Contenido de la caja 2: ${caja2.obtenerContenido()}")
    println("Contenido de la caja 3: ${caja3.obtenerContenido()}")
    println("Contenido de la caja 4: ${caja4.obtenerContenido()}")
}
