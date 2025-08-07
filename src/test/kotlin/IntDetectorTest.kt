import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class IntDetectorTest {
    val detector = IntDetector()

    @Test
    fun testValidInts() {
        val validIntStrings = mutableListOf<String>(
            "1",
            "120",
            "654984631318610506510651"
        )
        for (validIntString in validIntStrings) {
            assertTrue( detector.isValid(validIntString), "The value $validIntString failed" )
        }
    }

    @Test
    fun testStartWithZero() {
        assertFalse( detector.isValid("0") )
        assertFalse ( detector.isValid("010") )
    }

    @Test
    fun testHasNonDigit() {
        assertFalse ( detector.isValid("a0") )
        assertFalse ( detector.isValid("1a") )
    }

    @Test
    fun testEmptyString() {
        assertFalse { detector.isValid("") }
    }
}