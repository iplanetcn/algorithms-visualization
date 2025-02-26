import shape.Circle
import shape.Rectangle
import sort.*
import java.awt.EventQueue
/**
 * AlgorithmsVisualizer
 *
 * @author john
 * @since 2023-11-27
 */
class AlgorithmsVisualizer(private val screenWidth: Int, private val screenHeight: Int, private val amount: Int): ActionsListener {
    private var state: State = State.Stop
    private var sortType: SortType = SortType.Bubble

    private lateinit var rectangles: Array<Rectangle>
    private lateinit var circles:Array<Circle>

    private lateinit var frame: AlgorithmsFrame
    private var thread: Thread? = null

    init {
        EventQueue.invokeLater {
            frame = AlgorithmsFrame("Algorithms Visualization", screenWidth, screenHeight,this)
            generateShapes()
        }
    }

    private fun generateShapes() {
        generateRectangle()
        generateCircles()
    }

    private fun generateRectangle() {
        rectangles = Factory.generateRectangles(screenWidth, screenHeight, amount)
        frame.setRectangles(rectangles)
    }

    private fun generateCircles() {
        circles = Factory.generateCircles(screenWidth, screenHeight, amount)
        frame.setCircles(circles)
    }

    private fun run() {
        if (state != State.Run) {
            return
        }

        frame.apply {
            when (sortType) {
                SortType.Bubble -> sort(BubbleSort(DELAY) { repaint() })
                SortType.Merge -> sort(MergeSort(DELAY) { repaint() })
                SortType.Quick -> sort(QuickSort(DELAY) { repaint() })
                SortType.Select -> sort(SelectionSort(DELAY) { repaint() })
                SortType.Insert -> sort(InsertionSort(DELAY) { repaint() })
            }
        }
    }

    override fun onSortTypeChanged(sortType: SortType) {
        generateShapes()
        this.sortType = sortType
    }

    override fun onStateChanged(state: State) {
        if (this.state == state) {
            return
        }

        this.state = state
        if (state == State.Run) {
            this.thread = Thread { run() }
            thread?.start()
        }

        if (state == State.Pause) {
            try {
                @Suppress("DEPRECATION")
                thread?.stop()
            } finally {
                thread = null
            }
        }
    }
}