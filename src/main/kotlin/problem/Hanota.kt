package problem

class Hanota {
    private var origin: MutableList<Int> = mutableListOf()
    private var middle: MutableList<Int> = mutableListOf()
    private var target: MutableList<Int> = mutableListOf()

    private fun printInfo() {
        println(origin)
        println(middle)
        println(target)
        println()
    }

    /* 移动一个圆盘 */
    private fun move(src: MutableList<Int>, tar: MutableList<Int>) {
        // 从 src 顶部拿出一个圆盘
        val pan = src.removeAt(src.size - 1)
        // 将圆盘放入 tar 顶部
        tar.add(pan)

        printInfo()
    }

    /* 求解汉诺塔问题 f(i) */
    private fun dfs(i: Int, src: MutableList<Int>, buf: MutableList<Int>, tar: MutableList<Int>) {
        // 若 src 只剩下一个圆盘，则直接将其移到 tar
        if (i == 1) {
            move(src, tar)
            return
        }
        // 子问题 f(i-1) ：将 src 顶部 i-1 个圆盘借助 tar 移到 buf
        dfs(i - 1, src, tar, buf)
        // 子问题 f(1) ：将 src 剩余一个圆盘移到 tar
        move(src, tar)
        // 子问题 f(i-1) ：将 buf 顶部 i-1 个圆盘借助 src 移到 tar
        dfs(i - 1, buf, src, tar)
    }

    /* 求解汉诺塔问题 */
    fun solveHanota(origin: MutableList<Int>, middle: MutableList<Int>, target: MutableList<Int>) {
        this.origin = origin
        this.middle = middle
        this.target = target

        val n = origin.size
        // 将 A 顶部 n 个圆盘借助 B 移到 C
        dfs(n, origin, middle, target)
    }
}