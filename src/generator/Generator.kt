package generator

import entity.*

/**
 * Created by MohamadAmin on 1/19/18.
 */

class Generator(private val startSymbol: NonTerminal, private val rules: Map<NonTerminal, List<Rule>>) {

    fun generateStates(): List<State> {

        val states = hashMapOf<List<Rule>, State>()
        val startingRules = rules[startSymbol]!!
        generateState(startingRules, states)

        return states.values.sortedBy { it.number }

    }

    private fun generateState(startingRules: List<Rule>, states: HashMap<List<Rule>, State>): State {

        val links = hashMapOf<Term, State>()
        val state = State(states.size)
        states[startingRules] = state

        state.rules = startingRules
                .map { expandRule(it) }
                .flatMap { it -> it }

        state.rules.filter { it.nextTerm() is Transitable }
                .groupBy { it.nextTerm() }
                .onEach {
                    val newRules = it.value.map { it.increasePosition() }
                    if (states.containsKey(newRules)) {
                        links[it.key] = states[newRules]!!
                    } else {
                        links[it.key] = generateState(newRules, states)
                    }
                }

        state.links = links
        return state

    }

    private fun expandRule(rule: Rule): List<Rule> {
        val takenMap = hashMapOf<Rule, Boolean>()
        rules.values.flatMap { it -> it }
                .forEach { takenMap[it] = false }
        return expandInternal(rule, takenMap)
    }

    private fun expandInternal(rule: Rule, takenMap: HashMap<Rule, Boolean>): List<Rule> {
        val result = mutableListOf(rule)
        val nextTerm = rule.nextTerm()
        if (nextTerm is NonTerminal) {
            rules[nextTerm]
                    ?.filter { takenMap[it] == false }
                    ?.forEach {
                        takenMap[it] = true
                        result.addAll(expandInternal(it, takenMap))
                    }
        }
        return result
    }

}