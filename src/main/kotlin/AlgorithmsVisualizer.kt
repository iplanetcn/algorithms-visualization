import shape.Rectangle
import sort.BubbleSort
import sort.MergeSort
import sort.QuickSort
import sort.SelectionSort
import sort.SortType
import java.awt.EventQueue
import javax.swing.SwingUtilities

/**
 * AlgorithmsVisualizer
 *
 * @author john
 * @since 2023-11-27
 */
class AlgorithmsVisualizer(screenWidth: Int, screenHeight: Int, amount: Int) {
    private var state: State = State.Stop
    private var sortType: SortType = SortType.Bubble

    private var rectangles: Array<Rectangle> = Factory.generateRectangles(screenWidth, screenHeight, amount)

    private lateinit var frame: AlgorithmsFrame

    init {
        EventQueue.invokeLater {
            frame = AlgorithmsFrame("Algorithms Visualization", screenWidth, screenHeight, object : ActionsListener {
                override fun onSortTypeChanged(sortType: SortType) {
                    rectangles = Factory.generateRectangles(screenWidth, screenHeight, amount)
                    frame.setRectangles(rectangles)
                    this@AlgorithmsVisualizer.sortType = sortType
                }

                override fun onStateChanged(state: State) {
                    this@AlgorithmsVisualizer.state = state
                    if (state == State.Run) {
                        Thread { run() }.start()
                    }
                }
            })
            frame.setRectangles(rectangles)
        }
    }

    private fun run() {
        if (state != State.Run) {
            return
        }

        frame.apply {
            when (sortType) {
                SortType.Bubble -> sort(BubbleSort(16) { repaint() })
                SortType.Merge -> sort(MergeSort(16) { repaint() })
                SortType.Quick -> sort(QuickSort(16) { repaint() })
                SortType.Select -> sort(SelectionSort(16) { repaint() })
            }
        }
    }
}