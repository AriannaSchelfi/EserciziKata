//https://codingdojo.org/kata/Mastermind/

class Mastermind {

    private var numberWellPlaced : Int =0
    private var numberMisplaced: Int =0

    fun verifySequence(secret : List<String>, guess : List<String>): List<Int>{
        if (secret.size != guess.size) throw Exception("Lunghezze diverse non accettate")
        if(secret.isEmpty()) return listOf(-1, -1)

        for (i in guess.indices){
            verifyWellplaced(guess, i, secret)
            verifiyMissplaced(guess, i, secret)
        }
        return listOf(numberWellPlaced, numberMisplaced)
    }

    private fun verifiyMissplaced(guess: List<String>, i: Int, secret: List<String>) {
        val containsColor = guess[i] in secret
        val colorInDifferentPosition = guess[i] != secret[i]
        if (containsColor && colorInDifferentPosition) numberMisplaced++
    }

    private fun verifyWellplaced(guess: List<String>, i: Int, secret: List<String>) {
        val isSameColorAndPosition = guess[i] == secret[i]
        if (isSameColorAndPosition) numberWellPlaced++
    }
}