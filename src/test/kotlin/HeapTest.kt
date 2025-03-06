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
        maxHeap.push(10)
        maxHeap.push(5)
        maxHeap.push(15)
        println(maxHeap.peek()) // 输出：15
    }

    @Test
    fun testMaxHeap() {
        val minHeap = MinHeap<Int>()
        minHeap.push(10)
        minHeap.push(5)
        minHeap.push(15)
        println(minHeap.peek()) // 输出：5
    }
}
