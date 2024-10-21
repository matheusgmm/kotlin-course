package br.com.muccio.fundamentos

class MinhaClase(
    var nome: String,
    var endereco: String,
    var idade: Int
) {

    companion object {
        fun criaClasse(): MinhaClase {
            return MinhaClase("Matheus", "Rua teste", 23)
        }

        fun criarApartirDeSegundaClasse(segundaClasse: SegundaClasse): MinhaClase {
            return MinhaClase(segundaClasse.nome, segundaClasse.endereco, segundaClasse.idade)
        }
    }
}

class SegundaClasse(
    var nome: String,
    var endereco: String,
    var idade: Int
) {
    fun criaClasse(): SegundaClasse {
        return SegundaClasse("Matheus", "Rua teste", 23)
    }


}

fun main() {
    var segundaClasse = SegundaClasse("nome", "endereço", 10).criaClasse()

    var minhaClase = MinhaClase.criaClasse()
    var minhacLoader = MinhaClase.criarApartirDeSegundaClasse(segundaClasse)
}
