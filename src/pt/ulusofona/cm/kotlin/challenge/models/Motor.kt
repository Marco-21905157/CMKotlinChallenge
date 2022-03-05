package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoLigadoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel

class Motor (val cavalos: Int, val cilindrada: Int) {
    var ligado: Boolean = false

    override fun toString(): String {
        return "Motor | $cavalos | $cilindrada"
    }
}