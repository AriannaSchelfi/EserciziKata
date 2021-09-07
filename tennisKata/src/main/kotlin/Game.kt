class Game (private var namePlayer1: String, private var namePlayer2: String){
    private var scorePlayer1 : Int = 0
    private var scorePlayer2 : Int = 0

    fun getScore() : String{
        return if (scorePlayer1==4 && scorePlayer2<3){
            "$namePlayer1 win!"
        } else if (scorePlayer1<3 && scorePlayer2==4){
            "$namePlayer2 win!"
        } else if(scorePlayer1>=3 && scorePlayer2>=3){
            vantaggi()
        } else {
            punteggio()
        }
    }

    private fun punteggio() =
        "$namePlayer1 : ${translateScore(scorePlayer1)} - $namePlayer2 : ${translateScore(scorePlayer2)}"

    private fun vantaggi(): String {
        return if (scorePlayer1 == scorePlayer2 + 1) {
            "advantage $namePlayer1"
        } else if (scorePlayer1 + 1 == scorePlayer2) {
            "advantage $namePlayer2"
        } else if (scorePlayer1 == scorePlayer2) {
            "deuce"
        } else{
            vittoria()
        }
    }

    private fun vittoria(): String {
        return if (scorePlayer1 > scorePlayer2) {
            "$namePlayer1 win!"
        } else {
            "$namePlayer2 win!"
        }
    }

    private fun translateScore(score : Int) : String {
        return when(score) {
            0 -> "love"
            1 -> "fifteen"
            2 -> "thirty"
            3 -> "forty"
            else -> "errore"
        }
    }

    fun newPoint(giocatore: String) {
        if (giocatore == namePlayer1) {
            scorePlayer1++
        } else{
            scorePlayer2++
        }
    }
}