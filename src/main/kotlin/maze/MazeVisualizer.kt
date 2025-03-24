package maze

import DELAY
import java.awt.EventQueue

class MazeVisualizer(private val screenWidth: Int, private val screenHeight: Int, private val data: MazeData) {
    private lateinit var frame: MazeFrame
    private var thread: Thread? = null

    init {
        EventQueue.invokeLater {
            frame = MazeFrame("Maze Visualization", screenWidth, screenHeight)
            this.thread = Thread { run() }
            thread?.start()
        }
    }

    private fun run() {
        try {
            Thread.sleep(DELAY)
        } finally {
            frame.render(data)
        }
    }
}