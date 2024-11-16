@file:Suppress("DEPRECATED_IDENTITY_EQUALS")

fun main() {
    val userTime = 259200
    for(i in 1..200000){
        println(agoToText(i))
       Thread.sleep(5)
    }
}

fun agoToText(userTime : Int): String{
    var str = "был(а) сутки назад"
    val hours = declensionHours((userTime / 60)/60)
    val minutes = declensionMinutes(userTime/60)

    when {
        (userTime in 1..60) -> str = "был(a) только что"
        (userTime in 61..3600) -> str = if(userTime>=3600)
            "был(а) $hours час назад"
        else "был(а) $minutes назад"
        (userTime in 3601..86400) -> str = "был(a) $hours  назад"
        (userTime in 86400..172800) -> str = "был(а) сутки назад"
        (userTime in 172800..259200) -> str = "был(а) позавчера"
        (userTime > 259200) -> str = "был(а) давно"
    }
    return str
}

fun declensionMinutes(minutes: Int): String{
    var declension = "p"
    when{
        (minutes in 10..14) -> declension = "$minutes минут"
        (minutes % 10 === 1) -> declension = "$minutes минуту"
        (minutes % 10 in 2..4) -> declension = "$minutes минуты"
        (minutes % 10 in 5..9 || minutes % 10 == 0) -> declension = "$minutes минут"

    }
    return declension
}

fun declensionHours(hours: Int): String{
    var declension = "p"
    when{
        (hours in 5..20) -> declension = "$hours часов"
        (hours % 10 === 1) -> declension = "$hours час"
        (hours % 10 in 2..4) -> declension = "$hours часа"

    }
    return declension
}
