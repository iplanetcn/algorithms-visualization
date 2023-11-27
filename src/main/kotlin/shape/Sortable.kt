package shape

/**
 * SortShape
 *
 * @author john
 * @since 2023-11-27
 */
interface Sortable: Comparable<Sortable> {
    fun getValue(): Float

    override fun compareTo(other: Sortable): Int {
        return getValue().compareTo(other.getValue())
    }
}