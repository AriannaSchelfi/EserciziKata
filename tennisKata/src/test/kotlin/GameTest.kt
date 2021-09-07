import org.junit.Test
import kotlin.test.assertEquals

class GameTest{

    @Test
    fun lovePerPunteggioIniziale() {
        val gioco = Game("Nadal", "Djokovic")
        val score = gioco.getScore()
        assertEquals("Nadal : love - Djokovic : love", score)
    }

    @Test
    fun fifteenPerPunteggioUno() {
        val gioco = Game("Nadal", "Djokovic")
        gioco.newPoint("Nadal")
        gioco.newPoint("Djokovic")
        assertEquals("Nadal : fifteen - Djokovic : fifteen", gioco.getScore())
    }

    @Test
    fun thirtyPerPunteggioDue() {
        val gioco = Game("Nadal", "Djokovic")
        gioco.newPoint("Nadal")
        gioco.newPoint("Nadal")
        assertEquals("Nadal : thirty - Djokovic : love", gioco.getScore())
    }

    @Test
    fun fortyPerPunteggioTre() {
        val gioco = Game("Nadal", "Djokovic")
        for(i in 0..2){
            gioco.newPoint("Nadal")
        }
        assertEquals("Nadal : forty - Djokovic : love", gioco.getScore())
    }

    @Test
    fun advantageGiocatore1() {
        val gioco = Game("Nadal", "Djokovic")
        for(i in 0..2){
            gioco.newPoint("Nadal")
        }
        for(i in 0..2) {
            gioco.newPoint("Djokovic")
        }
        gioco.newPoint("Nadal")
        assertEquals("advantage Nadal", gioco.getScore())
    }

    @Test
    fun advantageGiocatore2() {
        val gioco = Game("Nadal", "Djokovic")
        for(i in 0..2){
            gioco.newPoint("Nadal")
        }
        for(i in 0..3){
            gioco.newPoint("Djokovic")
        }
        assertEquals("advantage Djokovic", gioco.getScore())
    }

    @Test
    fun deucePerPareggioDopoTrePunti() {
        val gioco = Game("Nadal", "Djokovic")
        for(i in 0..2){
            gioco.newPoint("Nadal")
        }
        for(i in 0..2){
            gioco.newPoint("Djokovic")
        }
        gioco.newPoint("Nadal")
        gioco.newPoint("Djokovic")
        assertEquals("deuce", gioco.getScore())
    }

    @Test
    fun vittoriaPrimaDeiTrePunti() {
        val gioco = Game("Nadal", "Djokovic")
        for(i in 0..3){
            gioco.newPoint("Nadal")
        }
        assertEquals("Nadal win!", gioco.getScore())
    }

    @Test
    fun vittoriaDopoTrePunti() {
        val gioco = Game("Nadal", "Djokovic")
        for(i in 0..2){
            gioco.newPoint("Nadal")
        }
        for(i in 0..4){
            gioco.newPoint("Djokovic")
        }
        assertEquals("Djokovic win!", gioco.getScore())
    }
}