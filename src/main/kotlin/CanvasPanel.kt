import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.RenderingHints
import javax.swing.JPanel
import kotlin.random.Random

/**
 * CanasPanel
 *
 * @author john
 * @since 2023-11-23
 */
class CanvasPanel : JPanel() {
    override fun paint(g: Graphics?) {
        super.paint(g)
        (g as Graphics2D).apply {
            setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)
            for (i in 0..width step 10) {
                color = Color.BLUE
                val iHeight = Random.nextInt(height / 2 - 100)
                fillRect(i, height / 2 - iHeight, 10, iHeight)
                color = Color.BLACK
                drawRect(i, height / 2 - iHeight, 10, iHeight)
            }
        }
    }
}