package onboarding

fun solution2(cryptogram: String): String {
//    TODO("프로그램 구현")
    var str = cryptogram
    var size = cryptogram.length
    var i = 0

    while (i < size - 1) {
        if (str[i] == str[i + 1]) {
            // delete i, i + 1
            str = str.removeRange(i, i + 2)
            i = 0
            size = str.length
        } else
            i++
    }
    return str
}

fun main() {
    val cryptogram = "zyelleyz"
    println("\"${solution2(cryptogram)}\"")
}
