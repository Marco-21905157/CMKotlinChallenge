package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoLigadoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel

class Carro(identificador: String, val motor: Motor) : Veiculo(identificador), Ligavel {
    override fun ligar() {
        motor.ligar()
    }

    override fun desligar() {
        motor.desligar()
    }

    override fun estaLigado(): Boolean {
        return motor.estaLigado()
    }

    override fun requerCarta(): Boolean {
        return true
    }

    override fun moverPara(x: Int, y: Int) {
        // Ligar o carro se nao estiver ligado
        if (!estaLigado()) {
            ligar()
        }
        // Movimentar o carro
        posicao.alterarPosicaoPara(x, y)

        // Terminar com o motor desligado
        desligar()
    }

    override fun toString(): String {
        return "Carro | ${super.toString()}"
    }
}