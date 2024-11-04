package lotto

fun purchase_money(): Int {
    val PURCHASE_MONEY_MESSAGE = "구입금액을 입력해주세요."
    var purchase_num: Int
    while (true) {
        println(PURCHASE_MONEY_MESSAGE)
        try {
            purchase_num = readLine()?.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 입력 값은 숫자로 입력해야 합니다.")
            require(purchase_num >= 0) { "[ERROR] 입력 값은 양수여야 합니다." }
            require(purchase_num % 1000 == 0) { "[ERROR] 입력 값은 1000단위이어야 합니다." }
            return purchase_num / 1000
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}

fun winNumberInput(): Any {
    val LOTTO_WIN_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요."
    while(true) {
        println("\n$LOTTO_WIN_NUMBERS_MESSAGE")
        try {
            val win_number = (readLine()?.split(",") ?: throw IllegalArgumentException()).map { it.trim().toInt() }
            Lotto(win_number)
            return win_number
        }catch (e:NumberFormatException){
            println("[ERROR] 당첨 번호는 숫자를 쉼표(,)로 구분해서 작성합니다.")
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}