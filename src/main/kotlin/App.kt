import java.awt.Dimension
import java.awt.Toolkit

private const val WINDOW_WIDTH = 800
private const val WINDOW_HEIGHT = 600
private const val N = 10
const val DELAY = 1000L

val SCREEN_SIZE: Dimension = Toolkit.getDefaultToolkit().screenSize

fun main() {
    AlgorithmsVisualizer(WINDOW_WIDTH, WINDOW_HEIGHT, N)
}