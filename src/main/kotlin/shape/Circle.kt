package shape

/**
 * Circle
 *
 * @author john
 * @since 2023-11-24
 */
class Circle(var x: Float, var y: Float, var radius: Float, var dx: Float = 0f, var dy: Float = 0f) {
    fun move() {
        x += dx
        y += dy
    }
}