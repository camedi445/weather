package co.cmedina.weather.util

fun String.ensureHttps(): String {
    return if (this.startsWith("http://") || this.startsWith("https://")) {
        this
    } else {
        "https://$this"
    }
}