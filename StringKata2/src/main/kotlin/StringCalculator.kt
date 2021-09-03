class StringCalculator {
    private var counter: Int =0

    fun add(stringa: String): Int {
        counter++

        if (stringa.isEmpty()) {
            return 0
        }
        val numeri = numeri(stringa)

        val numeriNegativi= numeriNegativi(numeri)

        if (numeriNegativiPresenti(numeriNegativi)) {
            throw Exception("Numeri negativi non permessi, presenti %s".format(numeriNegativi.toString()))
        }

        return numeri.sum();
    }

    private fun numeri(stringa: String): List<Int> {
        val delimiter1 = ","
        val delimiter2 = "\n"

        return estraiStringaPulita(stringa).split(delimiter1, delimiter2, estraiDelimitatore(stringa))
            .map { it.toInt() }
            .filter { it <= 1000 }
    }

    private fun estraiStringaPulita(stringa: String): String {
        val stringaPulita: String = if (stringa.startsWith("//[")) {
            stringa.substring(stringa.indexOf("\n") + 1)
        } else if (stringa.startsWith("//")) {
            stringa.substring(4)
        } else {
            stringa
        }
        return stringaPulita
    }

    private fun estraiDelimitatore(stringa: String): String {
        val delimiter3 = if (stringa.startsWith("//[")) {
            stringa.substring(3, stringa.indexOf('\n') - 1)
        } else if (stringa.startsWith("//")) {
            stringa[2].toString()
        } else {
            " "
        }
        return delimiter3
    }

    private fun numeriNegativi(numeri: List<Int>): List<Int> {
        return numeri.filter{ it<0}
    }

    private fun numeriNegativiPresenti(numeriNegativi: List<Int>) =
        numeriNegativi.isNotEmpty()

    fun getCalledCount(): Int {
        return counter
    }



}