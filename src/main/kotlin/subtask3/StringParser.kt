package subtask3

class StringParser {
    fun getResult(inputString: String): Array<String> {
        val resList : MutableList<String> = arrayListOf()
        var subStr = ""
        val charArray = inputString.toCharArray()
        var isSubStrStart = false
        var isHaveSecondBracket = false
        var reversChar = ' '
        try {
            var startIndex = 0
            while (startIndex < charArray.size) {
                for(index in startIndex until charArray.size) {
                    if (charArray[index] == '[' ) {
                        if(!isSubStrStart) {
                            isSubStrStart = true
                            isHaveSecondBracket = false
                            reversChar = ']'
                            startIndex = index + 1
                        } else if (!isHaveSecondBracket && (charArray[startIndex - 1] == '[')) {
                            subStr += charArray[index]
                            isHaveSecondBracket = true
                        } else {
                            subStr += charArray[index]
                        }
                    } else if (charArray[index] == '<') {
                        if(!isSubStrStart) {
                            isSubStrStart = true
                            isHaveSecondBracket = false
                            reversChar = '>'
                            startIndex = index + 1
                        } else if (!isHaveSecondBracket && (charArray[startIndex - 1] == '<')) {
                            subStr += charArray[index]
                            isHaveSecondBracket = true
                        } else {
                            subStr += charArray[index]
                        }
                    } else if (charArray[index] == '(') {
                        if(!isSubStrStart) {
                            isSubStrStart = true
                            isHaveSecondBracket = false
                            reversChar = ')'
                            startIndex = index + 1
                        } else if (!isHaveSecondBracket && (charArray[startIndex - 1] == '(')) {
                            subStr += charArray[index]
                            isHaveSecondBracket = true
                        } else {
                            subStr += charArray[index]
                        }
                    } else if (isSubStrStart) {
                        if (charArray[index] == reversChar) {
                            resList.add(subStr)
                            if((index == charArray.size - 1) || !isHaveSecondBracket) {
                                subStr = ""
                                isSubStrStart = false
                                break
                            } else {
                                subStr += charArray[index]
                            }
                        } else {
                            subStr += charArray[index]
                            if (index == charArray.size - 1) {
                                subStr = ""
                                isSubStrStart = false
                                break
                            }
                        }
                    } else if (!isSubStrStart && (index == charArray.size - 1)) {
                        startIndex = charArray.size
                    }
                }
            }
        } catch (e: NotImplementedError) {
            throw NotImplementedError("Not implemented")
        }

        return resList.toTypedArray()
    }
}
