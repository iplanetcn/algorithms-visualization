import shape.Circle
import shape.Rectangle
import java.awt.*
import javax.swing.JPanel

/**
 * CanvasPanel
 *
 * @author john
 * @since 2023-11-23
 */
class CanvasPanel : JPanel(true) {
    var rectangles: Array<Rectangle>? = null
    var circles: Array<Circle>? = null

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
                Helper.fillRectangle(g2d, rectangle.width * index + rectangle.width / 2, rectangle.y, rectangle.width, rectangle.height)
                Helper.setColor(g2d, Color.BLACK)
                Helper.strokeRectangle(g2d, rectangle.width * index + rectangle.width / 2, rectangle.y, rectangle.width, rectangle.height)
            }
        }

        circles?.apply {
            for ((index, circle) in withIndex()) {
                Helper.setStrokeWidth(g2d, 1f)
                Helper.setColor(g2d, Color.ORANGE)
                Helper.fillCircle(g2d, circle.radius * index + circle.radius / 2, circle.y, circle.radius / 2)
                Helper.setColor(g2d, Color.BLACK)
                Helper.strokeCircle(g2d, circle.radius * index + circle.radius / 2, circle.y, circle.radius / 2)
            }
        }

        Helper.setStrokeWidth(g2d, 1f)
        Helper.setColor(g2d, Color.RED)
        Helper.fillCircle(g2d, 0f, 0f, 50f)

    }
}