package k_06_funciones

fun main() {
    mostrarMensaje("Bienvenido al programa")
    sumarValores()
    mostrarMensaje("Gracias por usar el programa")
}

fun sumarValores() {
    print("Ingrese el primer valor: ")
    val valor1 = readln().toInt()
    print("Ingrese el segundo valor: ")
    val valor2 = readln().toInt()
    val resultado = valor1.plus(valor2)
    println("La suma de $valor1 y $valor2 es $resultado")
}

fun mostrarMensaje(mensaje: String) {  // Para cualquier tipo de dato usamos: Any
    println("*************************")
    println(mensaje)
    println("*************************")
}