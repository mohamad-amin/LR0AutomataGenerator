package entity

/**
 * Created by MohamadAmin on 1/19/18.
 */

sealed class Term(open val name: String)
    class End : Term("$")
    sealed class Transitable(name: String) : Term(name)
        data class Terminal(override val name: String) : Transitable(name)
        data class NonTerminal(override val name: String) : Transitable(name)
