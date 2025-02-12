package shape

import java.awt.Color

/**
 * Circle
 *
 * @author john
 * @since 2023-11-24
 */
class Circle(var x: Float, var y: Float, var radius: Float, color: Color = Color.ORANGE): SortableShape(color) {
    override fun getValue(): Float {
        return -y
    }

    override fun toString(): String {
        return "$y"
    }
}