package k_08_colecciones

fun main() {
    //val alturas = FloatArray(4)
    val sueldos = IntArray(5)
    for(i in 0..4) {
        print("Ingrese el sueldo del empleado ${i + 1}: ")
        sueldos[i] = readln().toInt()
    }
    println("Sueldos ingresados:")
    for(sueldo in sueldos) {
        println(sueldo)
    }
}