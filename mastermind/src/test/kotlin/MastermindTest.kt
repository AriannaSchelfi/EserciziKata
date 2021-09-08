
import org.junit.Test
import kotlin.test.assertEquals

class MastermindTest{
    @Test
    fun sequenzeVuote() {
        val mastermind = Mastermind()
        val result = mastermind.verifySequence(emptyList(), emptyList())
        assertEquals(listOf(-1,-1),result)
    }

    @Test
    fun sequenzeDiLunghezzeDiverseOttengoEccezzione() {
        val mastermind = Mastermind()
        try {
            mastermind.verifySequence(emptyList(), listOf("blue"))
        }catch(e : Exception){
            assertEquals("Lunghezze diverse non accettate", e.message)
        }

    }

    @Test
    fun sequenzeLunghezzaUnoNonIndovinata() {
        val mastermind = Mastermind()
        val result = mastermind.verifySequence(listOf("orange"), listOf("blue"))
        assertEquals(listOf(0,0),result)
    }

    @Test
    fun sequenzeLunghezzaUnoIndovinata() {
        val mastermind = Mastermind()
        val result = mastermind.verifySequence(listOf("blue"), listOf("blue"))
        assertEquals(listOf(1,0),result)
    }

    @Test
    fun sequenzeLunghezzaMaggioreDiUnoConSoloWellPlaced() {
        val mastermind = Mastermind()
        val result = mastermind.verifySequence(listOf("blue","orange", "red"), listOf("black","orange", "green"))
        assertEquals(listOf(1,0),result)
    }

    @Test
    fun sequenzeLunghezzaMaggioreDiUnoConSoloMissplaced() {
        val mastermind = Mastermind()
        val result = mastermind.verifySequence(listOf("blue","orange", "red"), listOf("black", "green","orange"))
        assertEquals(listOf(0,1),result)
    }

    @Test
    fun sequenzeLunghezzaMaggioreDiUnoConMissplacedEWellplaced() {
        val mastermind = Mastermind()
        val result = mastermind.verifySequence(listOf("blue", "red", "green", "pink"), listOf("yellow", "red", "blue", "pink"))
        assertEquals(listOf(2,1),result)
    }
}