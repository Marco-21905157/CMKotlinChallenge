package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoLigadoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel

class Carro(identificador: String, val motor: Motor) : Veiculo(identificador), Ligavel {
    override fun ligar() {
        if (motor.ligado) {
            throw VeiculoLigadoException()
        }
        motor.ligado = true
    }

    override fun desligar() {
        if (!motor.ligado) {
            throw VeiculoDesligadoException()
        }
        motor.ligado = false
    }

    override fun estaLigado(): Boolean {
        return motor.ligado
    }

    override fun requerCarta(): Boolean {
        return true
    }

    override fun moverPara(x: Int, y: Int) {
        if (estaLigado()) {
            posicao.alterarPosicaoPara(x, y)
        }
    }

    override fun toString(): String {
        return "Carro | ${super.toString()}"
    }
}