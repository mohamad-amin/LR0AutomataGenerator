import generator.Generator
import parser.ParserBuilder
import presenter.Presenter

/**
 * Created by MohamadAmin on 1/19/18.
 */

fun main(args: Array<String>) {

    lateinit var startSymbol: String
    val rules = mutableListOf<String>()
    val terminals = mutableListOf<String>()
    val nonTerminals = mutableListOf<String>()

    do {
        println("Enter terminals separated with a whitespace character")
        readLine()!!
                .split(' ')
                .map { terminals.add(it.trim()) }
    } while (terminals.isEmpty())

    do {
        println("Enter non-terminals separated with a whitespace character")
        readLine()!!
                .split(' ')
                .map { nonTerminals.add(it.trim()) }
    } while (nonTerminals.isEmpty())

    do {
        println("Enter start symbol")
        startSymbol = readLine()!!.trim()
    } while (startSymbol.isBlank())

    var rulesCount = -1
    do {
        println("Enter number of rules: ")
        try {
            rulesCount = readLine()!!.toInt()
        } catch (exception: Throwable) {}
    } while (rulesCount <= 0)

    for (i in 1..rulesCount) {
        do {
            println("Enter a rule, starting with a non-terminal, then \'->\' and then some terminal/non-terminal (s), " +
                    "\nNote: every terminal and \'-> sign\' in a rule must be separated from the previous tokens with a whitespace")
            rules.add(readLine()!!.trim())
        }  while (rules[i-1].isBlank())
    }

    val map = ParserBuilder()
            .rules(rules)
            .terminals(terminals)
            .nonTerminals(nonTerminals)
            .startSymbol(startSymbol)
            .create()
            .invoke()

    val states = Generator(map.first, map.second).generateStates()
    Presenter(states).present()

}