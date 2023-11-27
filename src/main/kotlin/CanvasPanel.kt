import shape.Rectangle
import java.awt.*
import javax.swing.JPanel

/**
 * CanasPanel
 *
 * @author john
 * @since 2023-11-23
 */
class CanvasPanel: JPanel(true) {
    var rectangles: Array<Rectangle>? = null
    override fun paintComponent(g: Graphics?) {
        super.paintComponent(g)

        (g as Graphics2D).apply {
            val hints = RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)
            addRenderingHints(hints)
            performPaint(this)
        }
    }

    private fun performPaint(g2d: Graphics2D) {
        rectangles?.apply {
            for ((index, rectangle) in withIndex()) {
                Helper.setStrokeWidth(g2d, 1f)
                Helper.setColor(g2d, Color.BLUE)
                Helper.fillRectangle(g2d, rectangle.width * index, rectangle.y, rectangle.width, rectangle.height)
                Helper.setColor(g2d, Color.BLACK)
                Helper.strokeRectangle(g2d, rectangle.width * index, rectangle.y, rectangle.width, rectangle.height)
            }
        }
    }
}