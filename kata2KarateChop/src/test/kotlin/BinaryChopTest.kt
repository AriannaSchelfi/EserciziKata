import org.junit.Test
import kotlin.test.assertEquals

class BinaryChopTest{

    @Test
    fun arrayVuotoRestituisceMenoUno() {
        val binaryChop = BinaryChop()
        val result =binaryChop.binarySearch(1, intArrayOf())
        assertEquals(-1,result)
    }

    @Test
    fun arrayConUnElementoPresente() {
        val binaryChop = BinaryChop()
        val result =binaryChop.binarySearch(1, intArrayOf(1))
        assertEquals(0,result)
    }

    @Test
    fun arrayConUnElementoNonPresente() {
        val binaryChop = BinaryChop()
        val result =binaryChop.binarySearch(3, intArrayOf(1))
        assertEquals(-1,result)
    }

    @Test
    fun arrayLunghezzaPariElementoPresente() {
        val binaryChop = BinaryChop()
        val result =binaryChop.binarySearch(9, intArrayOf(1,3,5,7,9,11))
        assertEquals(4,result)
    }

    @Test
    fun arrayLunghezzaPariElementoNonPresente() {
        val binaryChop = BinaryChop()
        val result =binaryChop.binarySearch(10, intArrayOf(1,3,5,7,9,11))
        assertEquals(-1,result)
    }

    @Test
    fun arrayLunghezzaDispariElementoPresente() {
        val binaryChop = BinaryChop()
        val result =binaryChop.binarySearch(4, intArrayOf(2,4,6,7,8))
        assertEquals(1,result)
    }

    @Test
    fun arrayLunghezzaDispariElementoNonPresente() {
        val binaryChop = BinaryChop()
        val result =binaryChop.binarySearch(6, intArrayOf(1,4,5,7,9))
        assertEquals(-1,result)
    }
}