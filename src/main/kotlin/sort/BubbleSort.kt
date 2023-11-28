package sort

import shape.Sortable

/**
 * BubbleSort
 *
 * @author john
 * @since 2023-11-28
 */
class BubbleSort(delay: Long, doAfterEachStep: () -> Unit) : BaseSort(delay, doAfterEachStep) {

    override fun <T : Sortable> sort(data: Array<T>) {
        val n = data.size
        for (i in 0..<n) {
            for (j in 0..<n - i - 1) {
                if (data[j] > data[j + 1]) {
                    swap(data, j, j + 1)
                }
            }
        }
    }

//    override fun <T : Sortable> sort(data: Array<T>) {
//        val n = data.size
//        for (i in 0..< n) {
//            for (j in 0..< n) {
//                if (data[i] < data[j]) {
//                    swap(data, i, j)
//                }
//            }
//        }
//    }
}