import org.junit.Test
import kotlin.test.assertEquals

class StringCalculatorTest{

    @Test
    fun stringa_vuota() {
        val calculator = StringCalculator();
        val result = calculator.add("");
        assertEquals(0, result);
    }

    @Test
    fun solo_un_numero() {
        val calculator = StringCalculator()
        val result= calculator.add("1")
        assertEquals(1, result)
    }

    @Test
    fun numeri_separati_da_virgola() {
        val calculator = StringCalculator()
        val result = calculator.add("1,2,3")
        assertEquals(6,result)
    }

    @Test
    fun numeri_con_piu_cifre() {
        val calculator = StringCalculator();
        val result = calculator.add("12,45,3")
        assertEquals(60, result)
    }

    @Test
    fun separatore_acapo() {
        val calculator = StringCalculator();
        val result =calculator.add("12\n45,3\n5")
        assertEquals(65,result)
    }

    @Test
    fun altri_separatori_prova_uno() {
        val calculator = StringCalculator();
        val result = calculator.add("//;\n45;12,8\n5")
        assertEquals(70,result)
    }

    @Test
    fun numero_negativo() {
        val calculator = StringCalculator();
        try {
            val result = calculator.add("//;\n23;-5,4")
        } catch (e : Exception ) {
            //System.err.println(e.message)
            assertEquals("Numeri negativi non permessi, presenti [-5]", e.message)
        }
    }

    @Test
    fun tanti_numeri_negativi() {
        val calculator = StringCalculator()
        try{
            val result = calculator.add("//;\n23;-5,4\n-6,5,-8")
        }
        catch(e : Exception){
            assertEquals("Numeri negativi non permessi, presenti [-5, -6, -8]", e.message)
        }
    }

    @Test
    fun funzione_getCalledCount_zero_chiamate() {
        val calculator = StringCalculator()
        val numeroChiamate= calculator.getCalledCount()
        assertEquals(0, numeroChiamate)
    }

    @Test
    fun funzione_getCalledCount_una_chiamata() {
        val calculator = StringCalculator()
        val result = calculator.add("1,2,3")
        val numeroChiamate = calculator.getCalledCount()
        assertEquals(1, numeroChiamate)
    }

    @Test
    fun funzione_getCalledCount_tante_chiamate() {
        val calculator = StringCalculator()
        val result1 = calculator.add("1,2,3")
        val result2 = calculator.add("//;\n1;2\n3,4")
        val result3 = calculator.add("1\n45,3")
        val numeroChiamate = calculator.getCalledCount()
        assertEquals(3,numeroChiamate)
    }

    @Test
    fun ignorare_numeri_maggiori_di_mille() {
        val calculator = StringCalculator()

        val result = calculator.add("1003,4,5,1001")

        assertEquals(9,result)
    }

    @Test
    fun delimitatori_lunghi_piu_di_un_carattere() {
        val calculator = StringCalculator()

        val result = calculator.add("//[***]\n1***2***3")

        assertEquals(6,result)
    }
}