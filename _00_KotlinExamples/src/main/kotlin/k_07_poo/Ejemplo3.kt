package k_07_poo

fun main() {
    val p = Person("Juan", "Perez", 30, "12345678")
    println(p)
}

data class Person(val name: String, val lastName: String, val age: Int, val dni: String) {

    override fun toString(): String {
        return "Nombre: $name\nApellido: $lastName\nEdad: $age\nDNI: $dni"
    }
}