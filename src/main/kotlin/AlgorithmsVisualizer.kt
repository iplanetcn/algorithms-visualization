import shape.Rectangle
import sort.BubbleSort
import java.awt.EventQueue

/**
 * AlgorithmsVisualizer
 *
 * @author john
 * @since 2023-11-27
 */
class AlgorithmsVisualizer(screenWidth: Int, screenHeight: Int, amount: Int) {
    private lateinit var frame: AlgorithmsFrame
    private var rectangles: Array<Rectangle> = Factory.generateRectangles(screenWidth, screenHeight, amount)
    init {
        EventQueue.invokeLater {
            frame = AlgorithmsFrame("Algorithms Visualization", screenWidth, screenHeight)
            frame.setRectangles(rectangles)
            Thread { run() }.start()
        }
    }

    private fun run() {
        frame.apply {
//            sort(SelectionSort(16) { repaint() })
//            sort(QuickSort(16) { repaint() })
//            sort(MergeSort(16) { repaint() })
            sort(BubbleSort(16) { repaint() })
        }
    }
}