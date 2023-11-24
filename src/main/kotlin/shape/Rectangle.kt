package shape

/**
 * Rectangle
 *
 * @author john
 * @since 2023-11-24
 */
class Rectangle(var x: Float, var y: Float, var width: Float, var height: Float, var dx: Float = 0f, var dy: Float = 0f) {
    fun move() {
        x += dx
        y += dy
    }
}