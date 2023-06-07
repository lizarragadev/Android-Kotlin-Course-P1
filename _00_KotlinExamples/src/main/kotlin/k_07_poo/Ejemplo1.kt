package k_07_poo

fun main() {
    val persona = Persona("Gustavo", "Lizarraga", 30, "234242342")
    println(persona.name)
    val persona2 = Persona2()
    persona2.inicializar("Luis", "Perez")
    persona2.imprimir()
}

class Persona(val name: String, val lastName: String, val age: Int, val dni: String)

class Persona2 {
    var name: String = ""
    var lastName: String = ""
    var age: Int = 18
    var dni: String = "234234234"

    fun inicializar(nom: String, lastn: String) {
        this.name = nom
        this.lastName = lastn
    }

    fun imprimir() {
        println("Nombre: $name")
        println("Apellido: $lastName")
        println("Edad: $age")
        println("DNI: $dni")
    }
}



