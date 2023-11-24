import shape.Circle
import shape.Rectangle
import java.awt.Color
import kotlin.random.Random
import kotlin.random.nextInt

/**
 * Factory
 *
 * @author john
 * @since 2023-11-24
 */
object Factory {
    fun generateCircles(): ArrayList<Circle> {
        val width = 800
        val height = 600
        val data: ArrayList<Circle> = arrayListOf()
        val shapeWidth = 20f
        val offset = 10f
        for (i in 0..<width step (shapeWidth + offset).toInt()) {
            val h: Float = Random.nextInt(height / 2 - 100).toFloat()
            val x = i.toFloat() + shapeWidth / 2
            val y = height / 2 - h / 2
            val dx = Random.nextInt(-5, 5).toFloat()
            val dy = Random.nextInt(-5, 5).toFloat()
            data.add(Circle(x,y, shapeWidth, dx, dy))
        }
        return data
    }

    fun generateRectangles(): ArrayList<Rectangle> {
        val width = 800
        val height = 600
        val data: ArrayList<Rectangle> = arrayListOf()
        val shapeWidth = 20f
        val offset = 10f
        for (i in 0..<width step (shapeWidth + offset).toInt()) {
            val h: Float = Random.nextInt(height / 2 - 100).toFloat()
            val x = i.toFloat() + shapeWidth / 2
            val y = height / 2 - h / 2
            data.add(Rectangle(x,y, shapeWidth, h))
        }
        return data
    }
}