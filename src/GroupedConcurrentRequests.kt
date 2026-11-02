import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds


suspend fun getAsString(x: Int) : String{
    delay(1000.milliseconds)
    return "$x"
}

suspend fun getAllStrings(): List<String> {

    val results = coroutineScope {
        val tasks = mutableListOf<Deferred<String>>()
        for (i in 1..25) {
            tasks.addLast(async { getAsString(i) })
        }
        tasks.awaitAll()
    }
    return results
}

//concise version of the above code
//suspend fun getAllStrings(): List<String> = coroutineScope {
//     (1..25).map {
//        async { getAsString(it) }
//    }.awaitAll()
//}

fun groupedConcurrentRequestsDemo() {
    runBlocking {
        val results = getAllStrings()
        println(results)
    }
}