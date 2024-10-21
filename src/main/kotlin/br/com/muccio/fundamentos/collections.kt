package br.com.muccio.fundamentos

fun main() {
//    var lista = listOf(1, 2, 3, 4, 6)
//    var pares = lista.filter { it % 2 == 0 }
//    println(pares)

//    var lista = mutableListOf(1, 2, 3, 4)
//    lista.add(6)

    var setNumeros = mutableSetOf(1, 2, 3, 2)
    println(setNumeros.contains(2))


    var mapNomeIdade = mutableMapOf("Matheus" to 23, "Lucas" to 16)
    println(mapNomeIdade)

    mapNomeIdade.put("Teste", 30)
    println(mapNomeIdade)

    mapNomeIdade["Teste"] = 30
    println(mapNomeIdade)

    mapNomeIdade.remove("Teste")
    println(mapNomeIdade)

}