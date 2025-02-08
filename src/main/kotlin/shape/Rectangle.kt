package shape

/**
 * Rectangle
 *
 * @author john
 * @since 2023-11-24
 */
class Rectangle(var x: Float, var y: Float, var width: Float, val height: Float): Sortable {
    override fun getValue(): Float {
        return height
    }

    override fun toString(): String {
        return "$height"
    }


}