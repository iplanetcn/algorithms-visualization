import java.awt.*
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import javax.swing.JFrame
import kotlin.random.Random
import kotlin.system.exitProcess


/**
 * Canvas
 *
 * @author john
 * @since 2023-11-23
 */
class MainFrame(title: String, frameWidth: Int, frameHeight: Int) : JFrame(title), KeyListener {
    //region Initialization
    init {
        setSize(frameWidth, frameHeight)
        setLocation((SCREEN_SIZE.width - frameWidth) / 2, (SCREEN_SIZE.height - frameHeight) / 2)
        addKeyListener(this)
        val canvasPanel = CanvasPanel()
        canvasPanel.preferredSize = Dimension(width/2, height/2)
        add(canvasPanel)
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
}