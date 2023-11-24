import shape.Circle
import shape.Rectangle
import java.awt.*
import javax.swing.JPanel

/**
 * CanasPanel
 *
 * @author john
 * @since 2023-11-23
 */
class CanvasPanel(
    var circles: ArrayList<Circle> = arrayListOf(),
    var rectangles: ArrayList<Rectangle> = arrayListOf()
) : JPanel() {
    override fun paintComponent(g: Graphics?) {
        super.paintComponent(g)

        (g as Graphics2D).apply {
            val hints = RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)
            addRenderingHints(hints)

            circles.forEach {
                Helper.setStrokeWidth(this, 1f)
                Helper.setColor(this, Helper.randomColor())
                Helper.fillCircle(this, it.x, it.y, it.radius)
                Helper.setColor(this, Helper.randomColor())
                Helper.strokeCircle(this, it.x, it.y, it.radius)
            }

            rectangles.forEach{
                Helper.setStrokeWidth(this, 1f)
                Helper.setColor(this, Helper.randomColor())
                Helper.fillRectangle(this, it.x, it.y, it.width, it.height)
                Helper.strokeRectangle(this, it.x, it.y, it.width, it.height)
            }

//            val shapeWidth = 20f
//            val offset = 10f
//            for (i in 0..<width step (shapeWidth + offset).toInt()) {
//                val h: Float = Random.nextInt(height / 2 - 100).toFloat()
//                val x = i.toFloat() + shapeWidth / 2
//                val y = height / 2 - h / 2
//                Helper.setStrokeWidth(this, 1f)
//                Helper.setColor(this, Color.RED)
//                Helper.fillRectangle(this, x, y, shapeWidth, h)
//                Helper.setColor(this, Color.BLUE)
//                Helper.strokeRectangle(this, x, y, shapeWidth, h)
//            }
        }
    }
}