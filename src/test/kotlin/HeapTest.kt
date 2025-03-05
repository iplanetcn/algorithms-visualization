import org.junit.jupiter.api.Test
import java.util.*


class HeapTest {
    @Test
    fun testHeap() {
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

    }
}
