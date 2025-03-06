import model.MaxHeap
import model.MinHeap
import org.junit.jupiter.api.Test
import java.util.*


class HeapTest {
    @Test
    fun testPriorityQueue() {
        /* 初始化列表 */
        val data = mutableListOf(1, 3, 2, 5, 4)
        // 初始化小顶堆
        val minHeap = PriorityQueue(data)
        // 初始化大顶堆（使用 lambda 表达式修改 Comparator 即可）
        val maxHeap = PriorityQueue(data.size) { a: Int, b: Int -> b - a }
        for (i in data) {
            maxHeap.add(i)
        }

        println(minHeap)
        println(maxHeap)

        while (minHeap.isNotEmpty()) {
            print("${minHeap.poll()} ")
        }

        println()

        while (maxHeap.isNotEmpty()) {
            print("${maxHeap.poll()} ")
        }

        println()
    }

    @Test
    fun testMinHeap() {
        val maxHeap = MaxHeap<Int>()
        maxHeap.insert(10)
        maxHeap.insert(5)
        maxHeap.insert(15)
        println(maxHeap.extractMax()) // 输出：15
    }

    @Test
    fun testMaxHeap() {
        val minHeap = MinHeap<Int>()
        minHeap.insert(10)
        minHeap.insert(5)
        minHeap.insert(15)
        println(minHeap.extractMin()) // 输出：5
    }
}
