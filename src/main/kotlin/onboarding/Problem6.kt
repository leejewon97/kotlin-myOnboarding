package onboarding

fun solution6(forms: List<List<String>>): List<String> {
//    TODO("프로그램 구현")
    if (false == validCheck(forms))
        return (listOf("Is not valid"))

    val emails = mutableListOf<String>()
	for (crew in forms) {
		val nickLen = crew[1].length
		var i = 0
		while (i < nickLen - 2) {
			val overlaps = checkOverlap(crew, i, forms)
            emails.addAll(overlaps)
			i++
		}
	}

	// emails 중복제거, 오름차순
	return emails
}

fun validCheck(forms: List<List<String>>): Boolean {
    return true
}

fun checkOverlap(crew: List<String>, i: Int, forms: List<List<String>>): List<String> {

}

