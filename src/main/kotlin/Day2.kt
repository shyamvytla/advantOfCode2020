import java.io.File

fun main() {
    val input = File("/home/shyamvytla/IdeaProjects/kotlin/src/main/resources/day2").readLines()
    println(one(input))
    println(two(input))
}

fun one(input: List<String>): Int {
    var items = 0
    for (i in input.indices) {
        val split = input[i].split(' ')
        val r = split[0].split('-')
        val range = r[0].toInt()..r[1].toInt()
        val char = split[1][0]
        val value = split[2]
        var occurrence = 0
        for (element in value) {
            if (char == element) {
                occurrence++
            }
        }
        if (occurrence > 0 && occurrence in range) {
            items++
        }
    }
    return items
}

fun two(input: List<String>): Int {
    var items = 0
    for (i in input.indices) {
        val split = input[i].split(' ')
        val r = split[0].split('-')
        val range = r[0].toInt()..r[1].toInt()
        val char = split[1][0]
        val value = split[2]
        var occurrence = 0
        for (element in value) {
            if (char == element) {
                occurrence++
            }
        }
        if (value[range.first-1] == char) {
            if (value[range.last-1] != char) {
                items++
            }
        } else if (value[range.last-1] == char) {
            items++
        }
    }
    return items
}
