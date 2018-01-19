package presenter

import entity.State

/**
 * Created by MohamadAmin on 1/19/18.
 */
class Presenter(private val states: List<State>) {

    fun present() {

        println("--------------------------------------------")
        println("----------------- RESULT -------------------")
        println("--------------------------------------------")
        println("Start state -> 0")
        println("--------------------------------------------")
        states.forEach {
            println("State ${it.number}")
            println("Rules:")
            it.rules.forEach { println("\t$it") }
            if (it.links.isNotEmpty()) {
                println("Links:")
                it.links.forEach { println("\t${it.key.name} -> ${it.value.number}") }
            }
            println("--------------------------------------------")
        }

    }

}