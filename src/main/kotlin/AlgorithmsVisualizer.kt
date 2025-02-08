import shape.Circle
import shape.Rectangle
import sort.BubbleSort
import sort.MergeSort
import sort.QuickSort
import sort.SelectionSort
import sort.SortType
import java.awt.EventQueue
/**
 * AlgorithmsVisualizer
 *
 * @author john
 * @since 2023-11-27
 */
class AlgorithmsVisualizer(val screenWidth: Int, val screenHeight: Int, val amount: Int) {
    private var state: State = State.Stop
    private var sortType: SortType = SortType.Bubble

    private lateinit var rectangles: Array<Rectangle>
    private lateinit var circles:Array<Circle>

    private lateinit var frame: AlgorithmsFrame

    init {
        EventQueue.invokeLater {
            frame = AlgorithmsFrame("Algorithms Visualization", screenWidth, screenHeight, object : ActionsListener {
                override fun onSortTypeChanged(sortType: SortType) {
                    generateShapes()
                    this@AlgorithmsVisualizer.sortType = sortType
                }

                override fun onStateChanged(state: State) {
                    this@AlgorithmsVisualizer.state = state
                    if (state == State.Run) {
                        Thread { run() }.start()
                    }
                }
            })
            generateShapes()
        }
    }

    private fun generateShapes() {
        rectangles = Factory.generateRectangles(screenWidth, screenHeight, amount)
        circles = Factory.generateCircles(screenWidth, screenHeight, amount)
        frame.setRectangles(rectangles)
        frame.setCircles(circles)
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