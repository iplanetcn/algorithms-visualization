package sort

import shape.Sortable

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

        Thread.sleep(delay)
        doAfterEachStep.invoke()
    }
}