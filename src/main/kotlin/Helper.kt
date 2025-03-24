import java.awt.BasicStroke
import java.awt.Color
import java.awt.Graphics2D
import java.awt.geom.Ellipse2D
import java.awt.geom.Rectangle2D

/**
 * AlgorithmsVisualizationHelper
 *
 * @author john
 * @since 2023-11-24
 */
object Helper {
    fun setColor(g2d: Graphics2D, color: Color) {
        g2d.color = color
    }

    fun setStrokeWidth(g2d: Graphics2D, w: Float) {
        g2d.stroke = BasicStroke(w, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)
    }

    fun strokeCircle(g2d: Graphics2D, x: Float, y: Float, radius: Float) {
        val circle = Ellipse2D.Float(x - radius, y - radius, radius * 2, radius * 2)
        g2d.draw(circle)
    }

    fun fillCircle(g2d: Graphics2D, x: Float, y: Float, radius: Float) {
        val circle = Ellipse2D.Float(x - radius, y - radius, radius * 2, radius * 2)
        g2d.fill(circle)
    }

    fun strokeSquare(g2d: Graphics2D, x: Float, y: Float, length: Float) {
        strokeRectangle(g2d, x, y, length, length)
    }

    fun strokeRectangle(g2d: Graphics2D, x: Float, y: Float, width: Float, height: Float) {
        val rectangle = Rectangle2D.Float(x - width / 2, y - height / 2, width, height)
        g2d.draw(rectangle)
    }

    fun fillSquare(g2d: Graphics2D, x: Float, y: Float, length: Float) {
        fillRectangle(g2d, x, y, length, length)
    }

    fun fillRectangle(g2d: Graphics2D, x: Float, y: Float, width: Float, height: Float) {
        val rectangle = Rectangle2D.Float(x, y, width, height)
        g2d.fill(rectangle)
    }

    fun randomColor(): Color {
        return arrayOf(
            Color.BLACK,
            Color.BLUE,
            Color.RED,
            Color.PINK,
            Color.ORANGE,
            Color.YELLOW,
            Color.GREEN,
            Color.MAGENTA,
            Color.CYAN
        ).random()
    }
}