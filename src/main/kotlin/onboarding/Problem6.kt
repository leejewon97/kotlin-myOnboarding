package onboarding

import java.util.regex.Pattern

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
	if (forms.size !in 1..10000)
		return false
	else if (!emailCheck(forms))
		return false
	else if (!nickCheck(forms))
		return false
    else
		return true
}

fun nickCheck(forms: List<List<String>>): Boolean {
	for (crew in forms) {
		if (!Pattern.matches("^[ㄱ-ㅎㅏ-ㅣ가-힣]{1,19}$", crew[1]))
			return false
	}
	return true
}

fun emailCheck(forms: List<List<String>>): Boolean {
	for (crew in forms) {
		if (!Pattern.matches("^[a-zA-Z0-9]{1,9}+@email.com$", crew[0]))
			return false
	}
	return true
}

fun checkOverlap(crew: List<String>, i: Int, forms: List<List<String>>): List<String> {

}

