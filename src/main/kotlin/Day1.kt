import java.io.File

fun main() {
    val input = File("/home/shyamvytla/IdeaProjects/kotlin/src/main/resources/day1").readLines()
    val sum = 2020
    //381699
    println(one(input, sum))
    //111605670
    println(two(input, sum))
}

fun one(input: List<String>, sum: Int): Int {
    val map = input.map { it.toInt() }
    val data = HashSet<Int>()
    for (i in input.indices) {
        if (data.contains(map[i])) {
            return map[i] * (sum - map[i])
        }
        data.add(sum - map[i])
    }
    return 0
}

fun two(input: List<String>, sum: Int): Int {
    val map = input.map { it.toInt() }
    for (i in 0..map.size-2) {
        val data = HashSet<Int>()
        val currSum = sum - map[i]
        for (j in i+1 until map.size) {
            if (data.contains(currSum - map[j])) {
                return map[i] * map[j] * (currSum - map[j])
            }
            data.add(map[j])
        }
    }
    return 0
}