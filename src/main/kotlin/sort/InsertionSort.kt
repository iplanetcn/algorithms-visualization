package sort

import shape.Sortable

class InsertionSort(delay: Long, doAfterEachStep: () -> Unit) : BaseSort(delay, doAfterEachStep) {
    override fun <T : Sortable> sort(data: Array<T>) {
        val n = data.size
        for (i in 1..<n) {
            val temp = data[i]
            var j = i - 1
            while (j >= 0 && data[j] > temp) {
                swap(data,j+1, j)
                j -= 1
                data[j + 1] = temp
            }
        }
    }
}