package pt.ulusofona.cm.kotlin.challenge.models

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import java.util.*

class Data {
    companion object {
        private fun converterData(data : Date) : LocalDate {
            val cal = Calendar.getInstance()
            cal.time = data

            return LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH))
        }

        fun formatar(data : Date) : String {
            val localdate = converterData(data)

            return localdate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
        }

        fun diferencaAnosAtualidade(data : Date) : Int {
            val localdate = converterData(data)

            return Period.between(localdate, LocalDate.now()).years
        }
    }
}