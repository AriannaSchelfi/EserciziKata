class BinaryChop {

    fun binarySearch(number : Int, orderedArray : IntArray, start :Int = 0) : Int{

        if (orderedArray.isNotEmpty()){
            val middle : Int= if(orderedArray.size%2 ==0){
                orderedArray.size /2
            }else{
                (orderedArray.size+1)/2
            }

            return if (orderedArray[middle-1] == number) {
                start+middle-1;
            } else if (orderedArray[middle-1] > number) {
                binarySearch(number, orderedArray.copyOfRange(0, middle-1), start)
            } else {
                binarySearch(number, orderedArray.copyOfRange(middle, orderedArray.size), start+middle)
            }
        }
        return -1
    }

}