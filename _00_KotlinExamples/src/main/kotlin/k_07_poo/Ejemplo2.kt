package k_07_poo

fun main() {
    val tri1 = Triangulo(4, 7,2)
    tri1.ladoMayor()

    val tri2 = Triangulo()
    tri2.ladoMayor()

    val tri3 = Triangulo(5)
    tri3.ladoMayor()
}

class Triangulo(var lado1: Int, var lado2: Int, var lado3: Int) {
    constructor(): this(0, 0, 0) {
        print("Ingrese el lado 1: ")
        lado1 = readln().toInt()
        print("Ingrese el lado 2: ")
        lado2 = readln().toInt()
        print("Ingrese el lado 3: ")
        lado3 = readln().toInt()
    }

    constructor(lado1: Int): this(lado1, 0, 0) {
        print("Ingrese el lado 2: ")
        this.lado2 = readln().toInt()
        print("Ingrese el lado 3: ")
        this.lado3 = readln().toInt()
    }

    fun ladoMayor() {
        print("El lado mayor es: ")
        when {
            lado1 > lado2 && lado1 > lado3 -> print(lado1)
            lado2 > lado1 && lado2 > lado3 -> print(lado2)
            lado3 > lado1 && lado3 > lado2 -> print(lado3)
        }
    }
}