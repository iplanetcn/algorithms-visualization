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
    fun generateCircles(width: Int, height: Int, amount: Int): ArrayList<Circle> {
        val data: ArrayList<Circle> = arrayListOf()
        val shapeWidth = width * 1.00000f / amount
        val offset = 10f
        for (i in 0..<width step (shapeWidth + offset).toInt()) {
            val h: Float = Random.nextInt(height / 2 - 100).toFloat()
            val x = i.toFloat() + shapeWidth / 2
            val y = height / 2 - h / 2
            val dx = Random.nextInt(-5, 5).toFloat()
            val dy = Random.nextInt(-5, 5).toFloat()
            data.add(Circle(x, y, shapeWidth, dx, dy))
        }
        return data
    }

    fun generateRectangles(width: Int, height: Int, amount: Int): Array<Rectangle> {
        val data: ArrayList<Rectangle> = arrayListOf()
        val step = width * 1.00000f / amount
        val offset = 0f
        for (i in 0..<width step (step + offset).toInt()) {
            val h: Float = Random.nextInt(height / 2 - 100).toFloat()
            val x = i.toFloat() + step / 2
            val y = height / 2 - h / 2
            val dx = Random.nextInt(-2, 2).toFloat()
            val dy = Random.nextInt(-2, 2).toFloat()
            data.add(Rectangle(x, y, step, h, dx, dy))
        }
        return Array(data.size) { data[it] }
    }
}