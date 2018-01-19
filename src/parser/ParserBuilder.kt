package parser

/**
 * Created by MohamadAmin on 1/19/18.
 */

class ParserBuilder {

    private lateinit var startSymbol: String
    private lateinit var terminals: List<String>
    private lateinit var rules: List<Pair<String, List<String>>>
    private lateinit var nonTerminals: List<String>

    fun rules(rules: List<String>): ParserBuilder {
        this.rules = rules.map {
                    it.split(' ')
                            .filter { it != "->" && it.isNotBlank() }
                }
                .map {
                    it.first() to it.drop(1)
                }
                .sortedBy { it.first }
        return this
    }

    fun terminals(terminals: List<String>): ParserBuilder {
        this.terminals = terminals
                .filter { it.isNotBlank() }
                .sorted()
        return this
    }

    fun nonTerminals(nonTerminals: List<String>): ParserBuilder {
        this.nonTerminals = nonTerminals
                .filter { it.isNotBlank() }
                .sorted()
        return this
    }

    fun startSymbol(name: String): ParserBuilder {
        startSymbol = name
        return this

    }

    fun create() = Parser(startSymbol, terminals, nonTerminals, rules)

}