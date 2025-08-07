import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class FloatingPointDetectorTest {
    val detector = FloatingPointDetector()

    @Test
    fun testValidFloatingPointNumbers() {
        val validFloatingPointStrings = mutableListOf<String>(
            "123.45",
            "0.0",
            ".0",
            ".4"
        )
        for (validFloatingPointString in validFloatingPointStrings) {
            assertTrue( detector.isValid(validFloatingPointString), "The value $validFloatingPointString failed" )
        }
    }

    @Test
    fun testStartWithZero() {
        assertTrue ( detector.isValid("0.0") )
        assertFalse( detector.isValid("01") )
        assertFalse ( detector.isValid("04.7") )
    }

    @Test
    fun testPeriod() {
        assertTrue ( detector.isValid("4.5") )
        assertFalse( detector.isValid("16") )
        assertFalse( detector.isValid("123.") )
        assertFalse( detector.isValid("982374956") )
        assertFalse ( detector.isValid("987.65.4") )
    }

    @Test
    fun testHasNonDigit() {
        assertFalse ( detector.isValid(".a0") )
        assertFalse ( detector.isValid("1.a") )
        assertFalse ( detector.isValid("1.9a") )
    }

    @Test
    fun testEmptyString() {
        assertFalse { detector.isValid("") }
    }
}