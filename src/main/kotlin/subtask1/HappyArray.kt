package subtask1

class HappyArray {

    // TODO: Complete the following function
    fun convertToHappy(sadArray: IntArray): IntArray {
        val array = IntArray(sadArray.size)
        var countElem = 0
        try {
            for (i in 0 until sadArray.size ) {
                if ((i > 0) && (i < (sadArray.size - 1))) {
                    if (!(sadArray[i] > (sadArray[i-1] + sadArray[i + 1]))) {
                        array[countElem] = sadArray[i]
                        countElem++
                    }
                } else if (i == 0 || i == sadArray.size - 1) {
                    array[countElem] = sadArray[i]
                    countElem++
                }
            }
            if(countElem == sadArray.size) {
                return array
            } else {
                val resultArray = array.dropLast(sadArray.size - countElem)
                val res = IntArray(resultArray.size)
                for (i in 0 until resultArray.size) res[i] = resultArray[i]

                return convertToHappy(res)
            }
        } catch (e: NotImplementedError) {
            throw NotImplementedError("Not implemented")
        }
    }
}