package maze

import CanvasPanel
import Helper
import SCREEN_SIZE
import java.awt.*
import javax.swing.JFrame

class MazeFrame(title: String, val frameWidth: Int, val frameHeight: Int) : JFrame(title) {
//    private var canvasPanel: CanvasPanel
    private var data: MazeData? = null

    init {
        val center = Point((SCREEN_SIZE.width - frameWidth) / 2, (SCREEN_SIZE.height - frameHeight) / 2)
        val dimension = Dimension(frameWidth, frameHeight)

        size = dimension
        location = center
//        canvasPanel = CanvasPanel().apply { preferredSize = dimension }
//        add(canvasPanel, BorderLayout.EAST)
        pack()
        defaultCloseOperation = EXIT_ON_CLOSE
        isResizable = false
        isVisible = true
    }

    fun render(data: MazeData) {
        this.data = data
        paintComponents(graphics)
    }

    override fun paintComponents(g: Graphics) {
        super.paintComponents(g)
        data?.run {
            val g2d = g as Graphics2D
            val hints = RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
            )
            hints[RenderingHints.KEY_RENDERING] = RenderingHints.VALUE_RENDER_QUALITY
            g2d.addRenderingHints(hints)

            val w = frameWidth.toFloat() / n
            val h = frameHeight.toFloat() / m

            for (i in 0..< n) {
                for (j in 0..< m) {
                    if (mazeOf(i, j) == '#') {
                        Helper.setColor(g2d, Color.BLACK)
                    } else {
                        Helper.setColor(g2d, Color.WHITE)
                    }
                    Helper.fillRectangle(g2d, (j * w), (i * h), w, h)
                }
            }
        }

    }

    override fun getPreferredSize(): Dimension {
        return Dimension(frameWidth, frameHeight)
    }
}