package maze

import java.io.BufferedInputStream
import java.util.Scanner
import java.util.regex.Pattern
import kotlin.properties.Delegates

class MazeData(filename: String) {
    var n by Delegates.notNull<Int>()
    var m by Delegates.notNull<Int>()
    private var maze: Array<Array<Char>>

    init {
        val fis = javaClass.classLoader.getResourceAsStream(filename)!!
        val scanner = Scanner(BufferedInputStream(fis), Charsets.UTF_8)
        val lines = scanner.nextLine()
        val pattern = Pattern.compile("\\s+")
        val nm = pattern.split(lines.trim())

        n = nm[0].trim().toInt()
        m = nm[1].trim().toInt()

        maze = Array(n) { Array(m) { ' ' } }

        // 读取后续的N行
        for (i in 0..<n) {
            val line = scanner.nextLine()
            // 每行保证有m个字符
            if (line.length != m) {
                throw IllegalArgumentException("Line does not match expected length: $line")
            }
            for (j in 0..<m) {
                maze[i][j] = line[j]
            }
        }
    }

    fun mazeOf(i: Int, j: Int): Char {
        if (!inArea(i, j)) {
            throw IllegalArgumentException("i or j must be in area")
        }
        return maze[i][j]
    }

    fun print() {
        println("$n $m")
        for (i in 0..<n) {
            for (j in 0..<m) {
                print(maze[i][j])
                if (j != m - 1) {
                    print(" ")
                }
            }
            println()
        }
    }

    private fun inArea(x: Int, y: Int): Boolean {
        return x in 0..<n && y in 0..<m
    }
}