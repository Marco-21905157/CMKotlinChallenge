package pt.ulusofona.cm.kotlin.challenge.models

class Carro(identificador: String, val motor: Motor) : Veiculo(identificador) {

    override fun requerCarta(): Boolean {
        return true
    }

    override fun moverPara(x: Int, y: Int) {
        if (motor.estaLigado()) {
            posicao?.alterarPosicaoPara(x, y)
        }
    }

    override fun toString(): String {
        return "Carro | $identificador | $dataDeAquisicao | $posicao"
    }
}