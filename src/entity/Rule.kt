package entity

/**
 * Created by MohamadAmin on 1/19/18.
 */

data class Rule(private val left : NonTerminal, private val right : List<Term>, private var position: Int = 0) {

    fun nextTerm() =
            if (position == right.size) End()
            else right[position]

    fun increasePosition(): Rule {
        if (position == right.size) {
            throw IllegalAccessException("position can't be more than $position")
        }
        val newRule = copy()
        newRule.position += 1
        return newRule
    }

    override fun toString(): String {
        var result = left.name + " -> "
        var position = 0
        right.forEach {
            if (position == this.position) {
                result += "."
            }
            result += it.name
            position += 1
        }
        if (this.position == right.size) {
            result += "."
        }
        return result
    }

}