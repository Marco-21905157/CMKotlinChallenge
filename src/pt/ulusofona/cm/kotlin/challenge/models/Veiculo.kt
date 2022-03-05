package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

abstract class Veiculo(val identificador: String) : Movimentavel {
    var posicao: Posicao? = null
    var dataDeAquisicao: Date? = null

    abstract fun requerCarta() : Boolean

    override fun toString(): String {
        val cal = Calendar.getInstance()
        cal.time = dataDeAquisicao

        val localDate = LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH))

        return "$identificador | ${localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))} | $posicao"
    }
}
