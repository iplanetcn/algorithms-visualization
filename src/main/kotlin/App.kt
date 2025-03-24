import maze.MazeData
import maze.MazeVisualizer
import java.awt.Dimension
import java.awt.Toolkit

private const val WINDOW_WIDTH = 800
private const val WINDOW_HEIGHT = 600
private const val N = 100
const val DELAY = 50L
const val SOUND_ON = false

val SCREEN_SIZE: Dimension = Toolkit.getDefaultToolkit().screenSize

fun main() {
    MazeVisualizer(WINDOW_WIDTH, WINDOW_HEIGHT, MazeData("maze_8_8.txt"))
//    AlgorithmsVisualizer(WINDOW_WIDTH, WINDOW_HEIGHT, N)
//    val mazeData = MazeData("maze_8_8.txt")
//    mazeData.print()
}