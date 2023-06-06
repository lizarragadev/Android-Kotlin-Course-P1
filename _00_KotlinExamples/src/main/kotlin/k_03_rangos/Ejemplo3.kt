package k_03_rangos

fun main() {
    val abecedario = 'a'..'z'
    val letra = 'g'
    if(letra in abecedario)
        print("La letra $letra está en el abecedario")
    else
        print("La letra $letra no está en el abecedario")
}