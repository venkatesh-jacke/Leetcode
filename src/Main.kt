import java.util.Stack

fun main() {
}

fun separateDigits(nums: IntArray): IntArray {

    return nums.flatMap { it.toString().map {ch->ch-'0' }}.toIntArray()
}