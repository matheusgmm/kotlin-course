package br.com.muccio.fundamentos

fun main() {

    var nome = "Matheus"
    val nomeVal = "Matheus"

    nome = "Lucas"
//    nomeVal = "Lucas"  #Error

    val idade = 24
    println(idade)

    val teste: String
    teste = "Teste"

}

class variaveis {
    lateinit var teste: String

    fun iniciarVariaveis() {
        teste = "Teste"
    }

}