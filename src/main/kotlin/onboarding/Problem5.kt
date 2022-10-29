package onboarding

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

fun solution5(money: Int): List<Int> {
//    TODO("프로그램 구현")
    var newMoney = money
    val bill = listOf(50_000, 10_000, 5000, 1000, 500, 100, 50, 10, 1)
    var changes = mutableListOf<Int>()
    for (i in bill) {
        var change = newMoney / i
        changes.add(change)
        newMoney -= change * i
    }
    return changes
}