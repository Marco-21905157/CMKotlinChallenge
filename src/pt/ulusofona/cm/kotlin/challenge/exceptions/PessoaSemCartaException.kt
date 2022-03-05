package pt.ulusofona.cm.kotlin.challenge.exceptions

import java.lang.Exception

class PessoaSemCartaException(val nomePessoa: String) : Exception()  {
    override val message: String?
        get() = "$nomePessoa não tem carta para conduzir o veículo indicado"
}