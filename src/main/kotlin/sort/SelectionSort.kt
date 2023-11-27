package sort

import shape.Sortable

/**
 * SelectionSort
 *
 * @author john
 * @since 2023-11-27
 */
class SelectionSort(delay: Long, doAfterEachStep: ()->Unit) : BaseSort(delay, doAfterEachStep) {
    override fun <T : Sortable> sort(data: Array<T>) {
        val n = data.size
        for (i in 0..<n) {
            for (j in i..<n) {
                if (data[i] > data[j]) {
                    swap(data, i, j)
                }
            }
        }
    }
}