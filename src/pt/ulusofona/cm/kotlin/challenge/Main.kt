package pt.ulusofona.cm.kotlin.challenge

import pt.ulusofona.cm.kotlin.challenge.models.Carro
import pt.ulusofona.cm.kotlin.challenge.models.Motor
import pt.ulusofona.cm.kotlin.challenge.models.Pessoa

fun main() {
    val p1 = Pessoa("Cristiano Ronaldo", Data(4, 3, 2000))

    p1.comprarVeiculo(Carro("1234", Motor(0, 0)))
    p1.comprarVeiculo(Carro("5678", Motor(0, 0)))
}