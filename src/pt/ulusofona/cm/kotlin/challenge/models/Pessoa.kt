package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.MenorDeIdadeException
import pt.ulusofona.cm.kotlin.challenge.exceptions.PessoaSemCartaException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoNaoEncontradoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.time.LocalDate

class Pessoa (val nome: String, val dataDeNascimento: Data) : Movimentavel {
    var veiculos: List<Veiculo> = ArrayList()
    var carta: Carta? = null
    var posicao: Posicao? = null

    override fun toString(): String {
        return "Pessoa | $nome | $dataDeNascimento | $posicao"
    }

    override fun moverPara(x: Int, y: Int) {
        posicao?.alterarPosicaoPara(x, y)
    }

    fun comprarVeiculo(veiculo: Veiculo) {
        // Criar copia da lista, mas como mutavel para podermos acrescentar o novo veiculo
        val v : MutableList<Veiculo> = veiculos.toMutableList()
        v.add(veiculo)

        // Substituir a lista pela nova lista ja com o novo veiculo
        veiculos = v
    }

    fun pesquisarVeiculo(identificador: String) : Veiculo {
        var v : Veiculo? = null

        for (veiculo in veiculos) {
            if (veiculo.identificador == identificador) {
                v = veiculo
                break
            }
        }

        if (v == null) {
            throw VeiculoNaoEncontradoException()
        }

        return v
    }

    fun venderVeiculo(identificador: String, comprador: Pessoa) {
        // Encontrar o veiculo
        val veiculo : Veiculo? = pesquisarVeiculo(identificador)

        // Se existir, vender
        if (veiculo != null) {
            // Remover veiculo
            val v : MutableList<Veiculo> = veiculos.toMutableList()
            v.remove(veiculo)

            veiculos = v

            // Comprador compra veiculo removido
            comprador.comprarVeiculo(veiculo)
        }
    }

    fun moverVeiculoPara(identificador: String, x: Int, y: Int) {
        // Encontrar veiculo
        val veiculo : Veiculo? = pesquisarVeiculo(identificador)

        // Se existir, mover
        if (veiculo != null) {
            if (veiculo.requerCarta() && !temCarta()) {
                throw PessoaSemCartaException(nome)
            } else {
                veiculo.moverPara(x, y) 
            }
        }
    }

    fun temCarta() : Boolean {
        return carta != null
    }

    fun tirarCarta() {
        val d = LocalDate.now()
        val dataAtual = Data(d.dayOfMonth, d.monthValue, d.year)

        if (dataAtual.diferencaAnos(dataDeNascimento) >= 18) {
            carta = Carta()
        } else {
            throw MenorDeIdadeException()
        }
    }
}