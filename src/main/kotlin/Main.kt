import java.awt.Dimension
import java.awt.EventQueue
import java.awt.Toolkit

private const val WINDOW_WIDTH = 800
private const val WINDOW_HEIGHT = 600
val SCREEN_SIZE: Dimension = Toolkit.getDefaultToolkit().screenSize
fun main() {
    EventQueue.invokeLater {
        val frame = MainFrame("Algorithms Visualization", WINDOW_WIDTH, WINDOW_HEIGHT)
        val circles = Factory.generateCircles()
        frame.renderCircles(circles)
    }
}