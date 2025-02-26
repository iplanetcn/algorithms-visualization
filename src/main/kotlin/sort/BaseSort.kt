package sort

import SOUND_ON
import shape.Sortable
import sound.ToneGenerator.playTone
import java.awt.Color

/**
 * Sort
 *
 * @author john
 * @since 2023-11-27
 */
abstract class BaseSort(private val delay: Long, private val doAfterEachStep: ()->Unit) {
    abstract fun <T: Sortable> sort(data: Array<T>)

    fun <T : Sortable> swap(data: Array<T>, first: Int, second: Int) {
        // 交换
        val temp = data[first]
        data[first] = data[second]
        data[second] = temp

        // 播放音调
        if (SOUND_ON) {
            playTone(44f * data[first].getValue(), delay.toInt(), 0.5f)
            playTone(440f * data[second].getValue(), delay.toInt(), 0.5f)
        }

        // 改变颜色
        data[first].changeColor(Color.green)
        data[second].changeColor(Color.green)

        try {
            Thread.sleep(delay)
        } finally {
            doAfterEachStep.invoke()
            data[first].resetColor()
            data[second].resetColor()
        }
    }
}