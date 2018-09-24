package hu.ait.android.tictactoe.model

object TicTacToeModel {

    public val CIRCLE: Short = 1
    public val CROSS: Short = 2
    public val EMPTY: Short = 0

    private val model =
        arrayOf(
            shortArrayOf(EMPTY, EMPTY, EMPTY),
            shortArrayOf(EMPTY, EMPTY, EMPTY),
            shortArrayOf(EMPTY, EMPTY, EMPTY)
        )

    private var nextPlayer = CIRCLE

    fun setFieldContent(x: Int, y: Int, player: Short) {
        model[x][y] = player
    }

    fun getFieldContent(x: Int, y: Int) = model[x][y]

    fun getNextPlayer() = nextPlayer

    fun changeNextPlayer() {
        nextPlayer = if (nextPlayer == CIRCLE) CROSS else CIRCLE
        // Java version
        /*if (nextPlayer == CIRCLE) {
            nextPlayer = CROSS
        } else {
            nextPlayer = CIRCLE
        }*/
    }

    fun resetModel() {
        for (i in 0..2) {
            for (j in 0..2) {
                model[i][j] = EMPTY
            }
        }
        nextPlayer = CIRCLE
    }

}

