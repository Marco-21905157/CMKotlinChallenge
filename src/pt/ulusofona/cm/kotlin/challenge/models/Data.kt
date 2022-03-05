package pt.ulusofona.cm.kotlin.challenge.models

class Data (val dia: Int, val mes: Int, val ano: Int) {
    override fun toString(): String {
        return "%02d".format(dia) + "-" + "%02d".format(mes) + "-" + "$ano"
    }

    fun diferencaAnos(data: Data) : Int {
        var diferenca = ano - data.ano

        if (mes < data.mes || (mes == data.mes && dia < data.dia)) {
            diferenca -= 1
        }

        return diferenca
    }
}