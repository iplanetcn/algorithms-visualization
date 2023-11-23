import java.awt.Dimension
import java.awt.EventQueue
import java.awt.Toolkit
import javax.swing.JFrame

private const val WINDOW_WIDTH = 800
private const val WINDOW_HEIGHT = 600
val SCREEN_SIZE: Dimension = Toolkit.getDefaultToolkit().screenSize
fun main() {
    EventQueue.invokeLater {
        val mainFrame = MainFrame("Algorithms Visualization", WINDOW_WIDTH, WINDOW_HEIGHT)
        mainFrame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        mainFrame.isResizable = false
        mainFrame.isVisible = true
    }
}