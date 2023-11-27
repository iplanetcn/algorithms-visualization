package sort

import shape.Sortable

/**
 * FastSort
 *
 * @author john
 * @since 2023-11-27
 */
class QuickSort(delay: Long, doAfterEachStep: ()->Unit) : BaseSort(delay, doAfterEachStep) {

    override fun <T : Sortable> sort(data: Array<T>) {
        quickSort(data, 0, data.size - 1)
    }

    private fun <T : Sortable> quickSort(array: Array<T>, left: Int, right: Int) {
        val index = partition(array, left, right)
        if (left < index - 1) { // 2) Sorting left half
            quickSort(array, left, index - 1)
        }
        if (index < right) { // 3) Sorting right half
            quickSort(array, index, right)
        }
    }

    private fun <T : Sortable> partition(array: Array<T>, l: Int, r: Int): Int {
        var left = l
        var right = r
        val pivot = array[(left + right) / 2] // 4) Pivot Point
        while (left <= right) {
            while (array[left] < pivot) left++ // 5) Find the elements on left that should be on right

            while (array[right] > pivot) right-- // 6) Find the elements on right that should be on left

            // 7) Swap elements, and move left and right indices
            if (left <= right) {
                swap(array, left, right)
                left++
                right--
            }
        }
        return left
    }
}