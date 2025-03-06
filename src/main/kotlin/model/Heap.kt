package model

interface Heap<T> {
    /**
     *  元素入堆
     */
    fun push(element: T)

    /**
     *  堆顶元素出堆
     */
    fun pop(): T?

    /**
     *  访问堆顶元素（对于大 / 小顶堆分别为最大 / 小值）
     */
    fun peek(): T?

    /**
     *  获取堆的元素数量
     */
    fun size(): Int

    /**
     *  判断堆是否为空
     */
    fun isEmpty(): Boolean
}