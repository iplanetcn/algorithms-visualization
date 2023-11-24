import shape.Circle
import shape.Rectangle
import java.awt.*
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import javax.swing.JFrame
import kotlin.system.exitProcess


/**
 * Canvas
 *
 * @author john
 * @since 2023-11-23
 */
class MainFrame(title: String, frameWidth: Int, frameHeight: Int) : JFrame(title), KeyListener {
    private var canvasPanel: CanvasPanel
    //region Initialization
    init {
        val center = Point((SCREEN_SIZE.width - frameWidth) / 2, (SCREEN_SIZE.height - frameHeight) / 2)
        val dimension = Dimension(frameWidth, frameHeight)

        size = dimension
        location = center
        canvasPanel = CanvasPanel().apply { preferredSize = dimension }
        contentPane = canvasPanel
        pack()
        defaultCloseOperation = EXIT_ON_CLOSE
        isResizable = false
        isVisible = true

        addKeyListener(this)
    }
    //endregion

    //region KeyListener Implementation
    override fun keyTyped(e: KeyEvent?) {
        e?.apply {
            println("$keyCode KeyTyped")
        }
    }

    override fun keyPressed(e: KeyEvent?) {
        e?.apply {
            println("$keyCode keyPressed")
            if (keyCode == KeyEvent.VK_ESCAPE) {
                exitProcess(0)
            }
        }
    }

    override fun keyReleased(e: KeyEvent?) {
        e?.apply {
            println("$keyCode keyReleased")
        }
    }
    //endregion

    fun renderCircles(circles: ArrayList<Circle>) {
        canvasPanel.circles.addAll(circles)
    }

    fun renderRectangles(rectangles: ArrayList<Rectangle>) {
        canvasPanel.rectangles.addAll(rectangles)
    }
}