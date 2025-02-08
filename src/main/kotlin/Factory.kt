import shape.Circle
import shape.Rectangle
import kotlin.random.Random

/**
 * Factory
 *
 * @author john
 * @since 2023-11-24
 */
object Factory {
    fun generateCircles(width: Int, height: Int, amount: Int): Array<Circle> {
        val data: ArrayList<Circle> = arrayListOf()
        val radius = width * 1.00000f / amount
        val offset = 0f
        for (i in 0..<width step (radius + offset).toInt()) {
            val x = i.toFloat()
            val y = Random.nextInt(height / 2 - 100).toFloat() + radius
            data.add(Circle(x, y, radius))
        }
        return Array(data.size) { data[it] }
    }

    fun generateRectangles(width: Int, height: Int, amount: Int): Array<Rectangle> {
        val data: ArrayList<Rectangle> = arrayListOf()
        val step = width * 1.00000f / amount
        val offset = 0f
        for (i in 0..<width step (step + offset).toInt()) {
            val h = Random.nextInt(height / 2 - 100).toFloat()
            val x = i.toFloat() + step / 2
            val y = height / 2 - h / 2
            data.add(Rectangle(x, y, step, h))
        }
        return Array(data.size) { data[it] }
    }
}