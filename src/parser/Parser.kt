package parser

import entity.NonTerminal
import entity.Rule
import entity.Terminal

/**
 * Created by MohamadAmin on 1/19/18.
 */

class Parser(private val startSymbol: String, private val terminals: List<String>,
             private val nonTerminals: List<String>, private val rules: List<Pair<String, List<String>>>) {

    private fun <T, R> HashMap<T, MutableList<R>>.add(key: T, value: R){
        if (containsKey(key)) {
            get(key)!!.add(value)
        } else {
            put(key, mutableListOf(value))
        }
    }

    operator fun invoke(): Pair<NonTerminal, Map<NonTerminal, List<Rule>>> {

        val startSymbol = NonTerminal(startSymbol)
        val terminals = this.terminals.map { Terminal(it) }
        val nonTerminals = this.nonTerminals.map { NonTerminal(it) }

        val rules = hashMapOf<NonTerminal, MutableList<Rule>>()

        this.rules
                .forEach { rule ->
                    val left = nonTerminals.find { it.name == rule.first } ?: throw RuntimeException(
                            "left value of " + "${rule.first} -> ${rule.second} wasn't identified as a non-terminal!")
                    val right = rule.second
                            .map { name ->
                                nonTerminals.find { it.name == name} ?:
                                terminals.find { it.name == name} ?: throw RuntimeException(
                                        "$name in " + "${rule.first} -> ${rule.second} wasn't identified as a term!")
                            }
                    rules.add(left, Rule(left, right))
                }

        return startSymbol to rules

    }

}