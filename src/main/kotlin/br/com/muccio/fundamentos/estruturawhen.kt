package br.com.muccio.fundamentos

fun main() {

    val x = 5

    when(x) {
        5 -> println("x == 5")
        8 -> println("x == 8")
        in 11..15 -> println("x esta entre 11 e 15")
        !in 16..20 -> println("Número não está no range 16 e 20")
        else -> println("Número não mapeado")
    }

    when {
        comecaComOi(5) -> println("S")
        comecaComOi("oi, tudo bem") -> println("oi, tudo bem")
    }
}


fun comecaComOi(x: Any): Boolean {
    return when(x) {
        is String -> x.startsWith("oi")
        else -> false
    }
}