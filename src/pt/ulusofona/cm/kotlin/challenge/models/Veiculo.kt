package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

abstract class Veiculo(val identificador: String) : Movimentavel {
    var posicao: Posicao = Posicao()
    var dataDeAquisicao: Date = Date()

    abstract fun requerCarta() : Boolean

    override fun toString(): String {
        val cal = Calendar.getInstance()
        cal.time = dataDeAquisicao

        val localDate = LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH))

        return "$identificador | ${localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))} | $posicao"
    }
}
