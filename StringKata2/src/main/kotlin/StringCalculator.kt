class StringCalculator {
    private var counter: Int =0

    fun add(stringa: String): Int {
        counter++

        if(stringa.isEmpty()) {
            return 0
        }
        /*
        var somma: Int=0
        var startNumber: Int =0
        for(i in 0..stringa.length-1){
            if(stringa[i]==','){//""stringa, '' char
                somma+=stringa.substring(startNumber,i).toInt()
                println("La somma è: %d".format(somma))
                startNumber = i+1
            }
        }
        somma+=stringa.substring(startNumber).toInt()
        println("La somma è: %d".format(somma))
        return somma.toInt();
        */

        val delimiter1 =","
        val delimiter2 = "\n"

        //verifico se ci sono altri separatori
        var delimiter3 = " "
        var stringaPulita : String
        if(stringa.startsWith("//")){
            delimiter3 = stringa[2].toString()
            stringaPulita = stringa.substring(4)
        }
        else{
            stringaPulita=stringa
        }
        val numeri = stringaPulita.split(delimiter1, delimiter2,delimiter3).map { it.toInt() }
        //println(numeri)

        //Verifico presenza numeri negativi e salvo in una lista per restituirli nel exception
        val numeriNegativi: MutableList<Int> = ArrayList()
        for(num in numeri) {
            if( num<0){
                numeriNegativi.add(num)
            }
        }

        //Se numeriNegativi non è vuota
        if(!numeriNegativi.isEmpty()){
            //println("Numeri negativi non permessi, presenti %s".format(numeriNegativi.toString()))
            throw Exception("Numeri negativi non permessi, presenti %s".format(numeriNegativi.toString()))
        }

        return numeri.sum();
    }

    fun getCalledCount(): Int {
        return counter
    }

}