package subtask2

class BillCounter {

    // TODO: Complete the following function
    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        var sum = 0
        val resStr: String
        try {
            for(item in bill) {
                sum += item
            }
            if((sum - bill[k]) / 2 == b) {
                resStr = "Bon Appetit"
            } else {
                resStr = (b - (sum - bill[k]) / 2).toString()
            }
        } catch (e: NotImplementedError) {
            throw NotImplementedError("Not implemented")
        }

        return resStr
    }
}