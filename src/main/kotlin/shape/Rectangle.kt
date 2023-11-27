package shape

/**
 * Rectangle
 *
 * @author john
 * @since 2023-11-24
 */
class Rectangle(var x: Float, var y: Float, var width: Float, var height: Float, var dx: Float = 0f, var dy: Float = 0f): Sortable {
    fun move() {
        x += dx
        y += dy
    }

    override fun getValue(): Float {
        return height
    }

    override fun toString(): String {
        return "$height"
    }


}