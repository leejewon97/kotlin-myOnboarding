package onboarding

fun solution3(number: Int): Int {
//    TODO("프로그램 구현")
    var count = 0
    var carNum = 1
    var digit = 0
    while (carNum <= number) {
        var tmp = carNum
        while (tmp > 0) {
            digit = tmp % 10
            if (digit == 6 || digit == 3 || digit == 9)
                count++
            tmp /= 10
        }
        carNum++
    }
    return count
}
