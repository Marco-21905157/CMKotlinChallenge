package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.util.*

abstract class Veiculo(val identificador: String) : Movimentavel {
    var posicao: Posicao? = null
    val dataDeAquisicao: Date? = null

    abstract fun requerCarta() : Boolean
}
