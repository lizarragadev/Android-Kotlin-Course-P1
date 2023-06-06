package k_03_rangos

fun main() {
    //val abecedario = ('a'..'z').reversed()
    val abecedario = 'z' downTo 'a'
    for(i in abecedario) {
        print("$i, ")
    }
}