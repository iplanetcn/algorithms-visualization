package shape

import java.awt.Color

/**
 * Rectangle
 *
 * @author john
 * @since 2023-11-24
 */
class Rectangle(var x: Float, var y: Float, var width: Float, val height: Float, color: Color = Color.BLUE): SortableShape(color) {
    override fun getValue(): Float {
        return height
    }

    override fun toString(): String {
        return "$height"
    }


}