class StringCalculator {
    private var counter: Int =0

    fun add(stringa: String): Int {
        counter++

        if (stringa.isEmpty()) {
            return 0
        }
        val numeri = numeri(stringa)



        val numeriNegativi: MutableList<Int> = numeriNegativi(numeri)

        if (numeriNegativiPresenti(numeriNegativi)) {
            throw Exception("Numeri negativi non permessi, presenti %s".format(numeriNegativi.toString()))
        }

        return numeri.sum();
    }

    private fun numeri(stringa: String): List<Int> {
        val delimiter1 = ","
        val delimiter2 = "\n"

        var delimiter3 = " "
        var stringaPulita: String
        if (stringa.startsWith("//[")) {
            delimiter3 = stringa.substring(3,stringa.indexOf('\n')-1)
            stringaPulita = stringa.substring(stringa.indexOf("\n")+1)

        }else if (stringa.startsWith("//")){
            delimiter3 = stringa[2].toString()
            stringaPulita = stringa.substring(4)
        }
        else {
            stringaPulita = stringa
        }
        val numeri = stringaPulita.split(delimiter1, delimiter2, delimiter3)
                    .map { it.toInt() }
                    .filter{it<=1000}

        return numeri
    }

    private fun numeriNegativi(numeri: List<Int>): MutableList<Int> {
        val numeriNegativi: MutableList<Int> = ArrayList()
        for (num in numeri) {
            if (num < 0) {
                numeriNegativi.add(num)
            }
        }
        return numeriNegativi
    }

    private fun numeriNegativiPresenti(numeriNegativi: MutableList<Int>) =
        numeriNegativi.isNotEmpty()

    fun getCalledCount(): Int {
        return counter
    }

}