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

        return estraiStringaPulita(stringa).split(*estraiDelimitatori(stringa).toTypedArray())
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

    private fun estraiDelimitatori(stringa: String): List<String> {

        val delimitatori = if (stringa.startsWith("//[")) {
            stringa.substring(3, stringa.indexOf('\n') - 1).split("][")
        } else if (stringa.startsWith("//")) {
            listOf(stringa[2].toString())
        } else {
            listOf(" ")
        }

        return listOf(",", "\n") + delimitatori
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