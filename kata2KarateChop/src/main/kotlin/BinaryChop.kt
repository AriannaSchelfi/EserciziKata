//http://codekata.com/kata/kata02-karate-chop/
class BinaryChop {

    fun binarySearch(element: Int, orderedArray: IntArray): Int {
        val lista: MutableList<Int> = orderedArray.toMutableList()

        return lista.indexOf(element)
    }
}