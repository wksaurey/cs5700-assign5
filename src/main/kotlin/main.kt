fun main() {
    val floatingPointTestStrings = mutableListOf<String>(
        "123.45",
        "0.0",
        ".0",
        ".4",
        "123.45a",
        "a",
        ".",
        "4.",
        "01.2"
    )
    testDetector(FloatingPointDetector(), floatingPointTestStrings)

    val intTestStrings = mutableListOf<String>(
        "120",
        "654984631318610506510651",
        "",
        "0123",
        "1a1",
        "0"
    )
    testDetector(IntDetector(), intTestStrings)

    val binaryTestStrings = mutableListOf<String>(
        "1",
        "11",
        "101",
        "1011",
        "0",
        "01",
        "10",
        "1010"
    )
    testDetector(BinaryDetector(), binaryTestStrings)

    val emailTestStrings = mutableListOf<String>(
        "a@a.a",
        ".@.a",
        "{}*$.&$*(@*$%&.*&*",
        "kolter.saurey@usu.edu",
        ".@.",
        "@.a",
        ".@.@.a",
        "a@a.a.",
        "kolter saurey@usu.edu"
    )
    testDetector(EmailDetector(), emailTestStrings)
}

fun testDetector(detector: Detector, testStrings: List<String>) {
    for (testString in testStrings) {
        var result = ""
        if (detector.isValid(testString)) result = "valid"
        else result = "invalid"
        println("$testString is ${result}")
    }
    println("")
}