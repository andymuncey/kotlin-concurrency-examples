import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

suspend fun getX(): String {
    delay(5000.milliseconds)
    return "X"
}

suspend fun getY(): String {
    delay(5000.milliseconds)
    return "Y"
}

fun awaitDemo() {
    runBlocking {

        print("Running 2 x 5 second tasks simultaneously")
        val start = System.currentTimeMillis()

        val x = async {getX()}
        val y = async {getY()}

        val coldplayAlbum = "${x.await()}&${y.await()}"
        val end = System.currentTimeMillis()

        println(coldplayAlbum)

        val elapsed = end - start
        println("Took $elapsed milliseconds")
    }
}