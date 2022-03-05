package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel

abstract class Veiculo(val identificador: String) : Movimentavel {
    var posicao: Posicao? = null
    val dataDeAquisicao: Data? = null

    abstract fun requerCarta() : Boolean
}
