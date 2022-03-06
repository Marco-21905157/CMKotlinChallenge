package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.MenorDeIdadeException
import pt.ulusofona.cm.kotlin.challenge.exceptions.PessoaSemCartaException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoNaoEncontradoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

class Pessoa (val nome: String, val dataDeNascimento: Date) : Movimentavel {
    var veiculos: MutableList<Veiculo> = ArrayList()
    var carta: Carta? = null
    var posicao: Posicao = Posicao()

    override fun toString(): String {
        val cal = Calendar.getInstance()
        cal.time = dataDeNascimento

        val localDate = LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH))

        return "Pessoa | $nome | ${localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))} | $posicao"
    }

    override fun moverPara(x: Int, y: Int) {
        posicao.alterarPosicaoPara(x, y)
    }

    fun comprarVeiculo(veiculo: Veiculo) {
        veiculos.add(veiculo)
    }

    fun pesquisarVeiculo(identificador: String) : Veiculo {
        for (veiculo in veiculos) {
            if (veiculo.identificador == identificador) {
                return veiculo
            }
        }

        throw VeiculoNaoEncontradoException()
    }

    fun venderVeiculo(identificador: String, comprador: Pessoa) {
        // Encontrar o veiculo
        val veiculo : Veiculo = pesquisarVeiculo(identificador)

        // Atualizar data de aquisicao
        veiculo.dataDeAquisicao = Date()

        // Retirar o veiculo da lista
        veiculos.remove(veiculo)

        // Comprador compra veiculo removido
        comprador.comprarVeiculo(veiculo)
    }

    fun moverVeiculoPara(identificador: String, x: Int, y: Int) {
        // Encontrar veiculo
        val veiculo : Veiculo = pesquisarVeiculo(identificador)

        // Se requer carta e a pessoa nao tem, excecao
        if (veiculo.requerCarta() && !temCarta()) {
            throw PessoaSemCartaException(nome)
        } else {
            veiculo.moverPara(x, y)
        }
    }

    fun temCarta() : Boolean {
        return carta != null
    }

    fun tirarCarta() {
        val cal = Calendar.getInstance()
        cal.time = dataDeNascimento

        val localDate = LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH))

        val idade = Period.between(localDate, LocalDate.now()).years

        if (idade >= 18) {
            carta = Carta()
        } else {
            throw MenorDeIdadeException()
        }
    }
}