//must add org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2
//via Project Structure - Libraries (unless project has Gradle)

fun main() {
    runAndWait { threeStepsUsingPyramid() }
    runAndWait { threeStepsUsingSuspend() }
    runAndWait { awaitDemo() }
    runAndWait { groupedConcurrentRequestsDemo() }
}

fun runAndWait(function: () -> Unit) {
    println("Press enter to continue:")
    function()
    readln()
}


//
//@Serializable
//data class Joke(
//    @SerialName("icon_url")
//    val iconUrl : String? = null,
//    val id : String? = null,
//    val url : String? = null,
//    @SerialName("value")
//    val content : String? = null
//)
