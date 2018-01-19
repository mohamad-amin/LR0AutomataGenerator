package entity

/**
 * Created by MohamadAmin on 1/19/18.
 */
data class State(val number: Int) {
    lateinit var rules: List<Rule>
    lateinit var links: HashMap<Term, State>
}