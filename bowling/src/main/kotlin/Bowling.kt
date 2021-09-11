const val STRIKE_OR_SPARE = 10

class Bowling {

    private var rolls = mutableListOf<Int>()


    fun roll(numberPins: Int) {

        if (numberPins == 10) {
            rolls.add(numberPins)
            rolls.add(0)
        } else {
            rolls.add(numberPins)
        }
    }

    fun getScore(): Int {
        var score = 0

        for (frame in 0..9) {
            val scoreOfThisFrame = scoreOf(frame)

            when {
                isSpare(frame) -> {
                    val scoreOfNextRoll = rolls[frame * 2 + 2]
                    score += (STRIKE_OR_SPARE + scoreOfNextRoll)
                }
                isStrike(frame) -> {
                    if (!isStrike(frame + 1)) {
                        score += (STRIKE_OR_SPARE + scoreOf(frame + 1))
                    } else {
                        val scoreOfThirdRoll = rolls[(frame + 2) * 2]
                        score += STRIKE_OR_SPARE + STRIKE_OR_SPARE + scoreOfThirdRoll
                    }
                }
                else -> score += scoreOfThisFrame
            }
        }
        return score
    }

    private fun isSpare(frame: Int): Boolean {
        return scoreOf(frame) == 10 && !isStrike(frame)
    }

    private fun scoreOf(frame: Int): Int {
        return rolls[frame * 2] + rolls[frame * 2 + 1]
    }

    private fun isStrike(frame: Int): Boolean {
        return rolls[frame * 2] == 10
    }
}

