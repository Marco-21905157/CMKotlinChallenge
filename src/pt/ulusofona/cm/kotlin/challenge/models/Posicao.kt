package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException

data class Posicao(var x: Int, var y: Int) {

    constructor() : this(0, 0)

    fun alterarPosicaoPara(x: Int, y: Int) {
        if (this.x == x && this.y == y) {
            throw AlterarPosicaoException()
        }

        this.x = x
        this.y = y
    }

    override fun toString(): String {
        return "Posicao | x:$x | y:$y"
    }
}