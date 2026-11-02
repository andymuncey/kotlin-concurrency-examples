import kotlinx.coroutines.runBlocking
import java.util.concurrent.Executors

val executor = Executors.newCachedThreadPool()

fun step1(completion: (String) -> Unit) {
    executor.submit {
        completion("Step 1 complete")
    }
}

fun step2(input: String, completion: (String) -> Unit) {
    executor.submit {
        completion("$input → Step 2 complete")
    }
}

fun step3(input: String, completion: (String) -> Unit) {
    executor.submit {
        completion("$input → Step 3 complete")
    }
}


fun threeStepsUsingPyramid(){
    // Pyramid of Doom using callbacks
    step1 { result1 ->
        step2(result1) { result2 ->
            step3(result2) { result3 ->
                println(result3)
                //executor.shutdown()
            }
        }
    }
}


suspend fun step1() : String {
    return "Step 1 Complete"
}

suspend fun step2(input: String) : String {
    return "$input → Step 2 complete"
}

suspend fun step3(input: String) : String {
    return "$input → Step 3 complete"
}

 fun threeStepsUsingSuspend(){

     runBlocking {
         val step1Result = step1()
         val step2Result = step2(step1Result)
         val step3Result = step3(step2Result)
         println(step3Result)
     }
}