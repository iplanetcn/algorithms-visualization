package sort

import shape.Sortable

/**
 * MergeSort
 *
 * @author john
 * @since 2023-11-27
 */
class MergeSort(delay: Long, doAfterEachStep: ()->Unit) : BaseSort(delay, doAfterEachStep) {

    override fun <T : Sortable> sort(data: Array<T>) {
        val newData = mergeSort(data)
        for ((index, item) in newData.withIndex()) {
            var newIndex = index
            for ((originIndex, originItem) in data.withIndex()) {
                if (originItem == item) {
                    newIndex = originIndex
                    break
                }
            }
            swap(data, index, newIndex)
        }
    }

    private fun <T : Sortable> mergeSort(
        array: Array<T>,
        startIndex: Int = 0,
        endIndex: Int = array.size - 1
    ): Array<T> {
        if (array.size <= 1) {
            return array
        }

        val middleIndex = (startIndex + endIndex) / 2
        val leftArray = array.sliceArray(startIndex..middleIndex)
        val rightArray = array.sliceArray(middleIndex + 1..endIndex)

        return merge(mergeSort(leftArray), mergeSort(rightArray))
    }

    private fun <T: Sortable> merge(leftArray: Array<T>, rightArray: Array<T>): Array<T> {
        val mergedArray = leftArray.plus(rightArray)
        var leftIndex = 0
        var rightIndex = 0
        var mergedIndex = 0

        while (leftIndex < leftArray.size && rightIndex < rightArray.size) {
            if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                mergedArray[mergedIndex] = leftArray[leftIndex]
                leftIndex++
            } else {
                mergedArray[mergedIndex] = rightArray[rightIndex]
                rightIndex++
            }
            mergedIndex++
        }

        while (leftIndex < leftArray.size) {
            mergedArray[mergedIndex] = leftArray[leftIndex]
            leftIndex++
            mergedIndex++
        }

        while (rightIndex < rightArray.size) {
            mergedArray[mergedIndex] = rightArray[rightIndex]
            rightIndex++
            mergedIndex++
        }

        return mergedArray
    }
}