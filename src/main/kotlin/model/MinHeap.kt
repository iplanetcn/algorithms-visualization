package model

class MinHeap<T : Comparable<T>>: Heap<T> {
    private val heap = mutableListOf<T>()

    private fun insert(element: T) {
        heap.add(element)
        heapifyUp(heap.size - 1)
    }

    private fun extractMin(): T? {
        if (heap.isEmpty()) return null
        val min = heap[0]
        heap[0] = heap.last()
        heap.removeAt(heap.size - 1)
        heapifyDown(0)
        return min
    }

    private fun heapifyUp(index: Int) {
        var currentIndex = index
        var parentIndex = (currentIndex - 1) / 2
        while (currentIndex > 0 && heap[currentIndex] < heap[parentIndex]) {
            swap(currentIndex, parentIndex)
            currentIndex = parentIndex
            parentIndex = (currentIndex - 1) / 2
        }
    }

    private fun heapifyDown(index: Int) {
        var currentIndex = index
        while (true) {
            var smallestIndex = currentIndex
            val leftChildIndex = 2 * currentIndex + 1
            val rightChildIndex = 2 * currentIndex + 2
            if (leftChildIndex < heap.size && heap[leftChildIndex] < heap[smallestIndex]) {
                smallestIndex = leftChildIndex
            }
            if (rightChildIndex < heap.size && heap[rightChildIndex] < heap[smallestIndex]) {
                smallestIndex = rightChildIndex
            }
            if (smallestIndex == currentIndex) break
            swap(currentIndex, smallestIndex)
            currentIndex = smallestIndex
        }
    }

    private fun swap(i: Int, j: Int) {
        val temp = heap[i]
        heap[i] = heap[j]
        heap[j] = temp
    }

    //region Heap Methods
    override fun push(element: T) {
        this.insert(element)
    }

    override fun pop(): T? {
        return extractMin()
    }

    override fun peek(): T? {
        if (heap.isEmpty()) return null
        return heap[0]
    }

    override fun size(): Int {
        return heap.size
    }

    override fun isEmpty(): Boolean {
        return heap.isEmpty()
    }
    //endregion
}