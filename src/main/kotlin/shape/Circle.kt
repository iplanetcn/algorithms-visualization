package shape

/**
 * Circle
 *
 * @author john
 * @since 2023-11-24
 */
class Circle(var x: Float, var y: Float, var radius: Float): Sortable {
    override fun getValue(): Float {
        return -y
    }

    override fun toString(): String {
        return "$y"
    }
}