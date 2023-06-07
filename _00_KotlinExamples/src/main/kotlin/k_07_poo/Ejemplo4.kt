package k_07_poo

fun main() {
    val p1 = Persona3("Juan", 30)
    p1.imprimir()

    val e1 = Empleado(3000.0, "Luis", 25)
    e1.imprimir()
    e1.imprimirSueldo()
    e1.pagaImpuestos()
}

open class Persona3(val nombre: String, val edad: Int) {
    open fun imprimir() {
        println("Nombre: $nombre")
        println("Edad: $edad")
    }
}

class Empleado(val sueldo: Double, nombre: String, edad: Int): Persona3(nombre, edad) {
    fun imprimirSueldo() {
        println("Sueldo: $sueldo")
    }

    fun pagaImpuestos() {
        if(sueldo > 3000) {
            println("El empleado $nombre debe pagar impuestos")
        } else {
            println("El empleado $nombre no paga impuestos")
        }
    }
}