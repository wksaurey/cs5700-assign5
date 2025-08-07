import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BinaryDetectorTest {
    val detector = BinaryDetector()

    @Test
    fun testValidBinaryNumberss() {
        val validBinaryStrings = mutableListOf<String>(
            "1",
            "11",
            "101",
            "1011",
        )
        for (validBinaryString in validBinaryStrings) {
            assertTrue( detector.isValid(validBinaryString), "The value $validBinaryString failed" )
        }
    }

    @Test
    fun testStartWithZero() {
        assertFalse( detector.isValid("0") )
        assertFalse( detector.isValid("01") )
        assertFalse ( detector.isValid("010") )
        assertFalse ( detector.isValid("011") )
    }

    @Test
    fun testEndsWithZero() {
        assertFalse( detector.isValid("10") )
        assertFalse ( detector.isValid("10110") )
    }

    @Test
    fun testHasNonBinaryDigit() {
        assertFalse ( detector.isValid("a0") )
        assertFalse ( detector.isValid("1a") )
        assertFalse ( detector.isValid("101081") )
        assertFalse ( detector.isValid("121") )
    }

    @Test
    fun testEmptyString() {
        assertFalse { detector.isValid("") }
    }
}