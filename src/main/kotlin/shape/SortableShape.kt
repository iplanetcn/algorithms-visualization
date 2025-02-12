package shape

import java.awt.Color

abstract class SortableShape(var color: Color): Sortable {
    val defaultColor = color

    override fun changeColor(color: Color) {
        this.color = color
    }

    override fun resetColor() {
        this.color = defaultColor
    }
}