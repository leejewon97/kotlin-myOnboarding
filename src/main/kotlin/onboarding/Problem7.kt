package onboarding

// 1. friends 에서 user 찾기
// 2. user의 친구목록 생성 (중복불가)
// 3. 함아친 목록 생성 (ex : [a, j, a, j])
// 4. 3에서 중복하는 만큼 +10  (ex : [a, 20], [j, 20])
//	 4-1. 새로 들어오면, 생성 후 10
//	 4-2. 이미 존재하면, 해당 아이디 +10
// 5. visitors에서 4와 같으나 +1
// 6. 4, 5 합산 후 return
fun solution7(
	user: String,
	friends: List<List<String>>,
	visitors: List<String>
): List<String> {
//    TODO("프로그램 구현")
	val result: List<String>
	val friendsList: List<String> = make4ndsList(user, friends)
	val mutual4ndList: List<String> = makeMutual4ndList(friendsList, friends)
	val mutualScore = calcScore(mutual4ndList, 10)
	val visitScore = calcScore(visitors, 1).toMutableList()
	val plusScore = mutableListOf<List<Any>>()
	// [b,10] [j,20]
	// [a,1] [b,1] [c,2] [j,1]
	for (mut4nd in mutualScore) {
		var visit4nd = 0
		while (visit4nd < visitScore.size) {
			if (mut4nd[0] == visitScore[visit4nd][0]) {
				plusScore.add(listOf(mut4nd[0], mut4nd[1] as Int + visitScore[visit4nd][1] as Int))
				visitScore.removeAt(visit4nd)
			} else
				visit4nd++
		}
	}

	plusScore.addAll(visitScore)
	result = organizeResult(plusScore)
	return result
}

fun organizeResult(plusScore: MutableList<List<Any>>): List<String> {
	// 점수, 이름순 정렬
	plusScore.sortWith(compareBy({ it[1] as Comparable<*> }, { it[0] as Comparable<*> }))
	// 5개까지만
	val psLength = plusScore.size
	if (psLength > 5) {
		var i = 5
		while (i < psLength) {
			plusScore.removeAt(i)
			i++
		}
	}
	// 점수 0 제외
	for (friend in plusScore) {
		if (friend[1] == 0)
			plusScore.remove(friend)
	}
	// 이름만 건넴
	val result = mutableListOf<String>()
	for (friend in plusScore) {
		result.add(friend[0].toString())
	}
	return result
}

fun calcScore(friendsList: List<String>, i: Int): List<List<Any>> {
// 4. 3에서 중복하는 만큼 +10  (ex : [a, 20], [j, 20])
//	 4-1. 새로 들어오면, 생성 후 10
//	 4-2. 이미 존재하면, 해당 아이디 +10
	val scoreList = mutableListOf<MutableList<Any>>()
	for (friend in friendsList) {
		var new = true
		for (score in scoreList) {
			if (friend == score[0]) {
				score[1] = score[1] as Int + i
				new = false
				break
			}
		}
		if (new)
			scoreList.add(mutableListOf(friend, i))
	}
	return scoreList
}

fun makeMutual4ndList(friendsList: List<String>, friends: List<List<String>>): List<String> {
	val mutual4ndList = mutableListOf<String>()
	for (userFriend in friendsList) {
		mutual4ndList.addAll(make4ndsList(userFriend, friends))
	}
	return mutual4ndList
}

fun make4ndsList(user: String, friends: List<List<String>>): List<String> {
	val friendsList = mutableListOf<String>()
	for (friend in friends) {
		if (friend[0] == user)
			friendsList.add(friend[1])
		else if (friend[1] == user)
			friendsList.add(friend[0])
	}
	return friendsList
}
