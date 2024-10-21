package br.com.muccio.fundamentos;

class Carro(var cor: String, var ano: Int, var dono: Dono) { }


data class Dono(var nome: String, var idade: Int) { }

fun main() {
    var carro = Carro("Branco", 2021, Dono("Matheus", 23))
    println(carro.cor)
    carro.cor = "Preto"
    println(carro.cor)
    println(carro.dono.nome)
}