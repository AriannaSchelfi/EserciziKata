import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BowlingTest{

    @Test
    internal fun dieciFrameConZeroBirilli() {
        val gioco = Bowling()

        for(i in 0..9){
            gioco.roll(0)
            gioco.roll(0)
        }
        val score = gioco.getScore()

        assertEquals(0, score)
    }

    @Test
    internal fun dieciFrameSenzaStrikeESpare() {
        val gioco = Bowling()

        for(i in 0..9){
            gioco.roll(1)
            gioco.roll(2)
        }
        val score = gioco.getScore()

        assertEquals(30,score)
    }

    @Test
    internal fun spareInUnFrameIntermedio() {
        val gioco = Bowling()

        gioco.roll(1)
        gioco.roll(1)
        gioco.roll(1)
        gioco.roll(9)
        for(i in 0..7){
            gioco.roll(1)
            gioco.roll(2)
        }
        val score = gioco.getScore()

        assertEquals(2+(10+1)+8*3,score )
    }

    @Test
    internal fun strikeInUnFrameIntermedio() {
        val gioco = Bowling()

        gioco.roll(1)
        gioco.roll(1)
        gioco.roll(10)
        for(i in 0..7){
            gioco.roll(1)
            gioco.roll(2)
        }
        val score = gioco.getScore()

        assertEquals(2+(10+3)+8*3,score )
    }

    @Test
    internal fun dueStrikeDiFila() {
        val gioco = Bowling()

        gioco.roll(1)
        gioco.roll(1)
        gioco.roll(10)
        gioco.roll(10)
        for(i in 0..6){
            gioco.roll(1)
            gioco.roll(2)
        }
        val score = gioco.getScore()

        assertEquals(2+21+13+7*3,score )
    }

    @Test
    internal fun dodiciStrike() {
        val gioco = Bowling()

        for(i in 0..11){
            gioco.roll(10)
        }
        val score = gioco.getScore()

        assertEquals(30*10,score )
    }

    @Test
    internal fun dieciVolteNove() {
        val gioco = Bowling()

        for(i in 0..9){
            gioco.roll(9)
            gioco.roll(0)
        }
        val score = gioco.getScore()

        assertEquals(90,score )
    }

    @Test
    internal fun tuttiFrameSparePiuLancioFinale() {
        val gioco = Bowling()

        for(i in 0..9){
            gioco.roll(5)
            gioco.roll(5)
        }
        gioco.roll(5)
        val score = gioco.getScore()

        assertEquals(10*15,score)
    }
}