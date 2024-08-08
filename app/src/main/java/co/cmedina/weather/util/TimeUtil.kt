package co.cmedina.weather.util

fun String.extractTime(): String {
    val parts = this.split(" ")
    return parts[1]
}

fun String.extractDate(): String {
    val parts = this.split(" ")
    return parts[0]
}
