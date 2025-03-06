package model

class MaxHeap<T : Comparable<T>> {
    private val heap = mutableListOf<T>()

    fun insert(element: T) {
        heap.add(element)
        heapifyUp(heap.size - 1)
    }

    fun extractMax(): T? {
        if (heap.isEmpty()) return null
        val max = heap[0]
        heap[0] = heap.last()
        heap.removeAt(heap.size - 1)
        heapifyDown(0)
        return max
    }

    private fun heapifyUp(index: Int) {
        var currentIndex = index
        var parentIndex = (currentIndex - 1) / 2
        while (currentIndex > 0 && heap[currentIndex] > heap[parentIndex]) {
            swap(currentIndex, parentIndex)
            currentIndex = parentIndex
            parentIndex = (currentIndex - 1) / 2
        }
    }

    private fun heapifyDown(index: Int) {
        var currentIndex = index
        while (true) {
            var largestIndex = currentIndex
            val leftChildIndex = 2 * currentIndex + 1
            val rightChildIndex = 2 * currentIndex + 2
            if (leftChildIndex < heap.size && heap[leftChildIndex] > heap[largestIndex]) {
                largestIndex = leftChildIndex
            }
            if (rightChildIndex < heap.size && heap[rightChildIndex] > heap[largestIndex]) {
                largestIndex = rightChildIndex
            }
            if (largestIndex == currentIndex) break
            swap(currentIndex, largestIndex)
            currentIndex = largestIndex
        }
    }

    private fun swap(i: Int, j: Int) {
        val temp = heap[i]
        heap[i] = heap[j]
        heap[j] = temp
    }
}