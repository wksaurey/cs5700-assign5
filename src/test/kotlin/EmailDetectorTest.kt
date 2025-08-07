import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class EmailDetectorTest {
    val detector = EmailDetector()

    @Test
    fun testValidEmails() {
        val validEmailStrings = mutableListOf<String>(
            "a@a.a",
            ".@a.a",
            "{}*$.&$*(@*$%&.*&*",
            "kolter.saurey@usu.edu",
        )
        for (validEmailString in validEmailStrings) {
            assertTrue( detector.isValid(validEmailString), "The value $validEmailString failed" )
        }
    }

    @Test
    fun testEmptyPart1() {
        assertFalse( detector.isValid("@a.a") )
        assertFalse ( detector.isValid("@gmail.com") )
    }

    @Test
    fun testEmptyPart2() {
        assertFalse( detector.isValid("A@.a") )
        assertFalse ( detector.isValid("kolter@.com") )
    }

    @Test
    fun testEmptyPart3() {
        assertFalse( detector.isValid("A@&.") )
        assertFalse ( detector.isValid("kolter@gmail.") )
    }

    @Test
    fun hasSpace() {
        assertFalse( detector.isValid(" A@b.3") )
        assertFalse( detector.isValid("A @b.3") )
        assertFalse( detector.isValid("A@ b.3") )
        assertFalse( detector.isValid("A@b .3") )
        assertFalse( detector.isValid("A@b. 3") )
        assertFalse( detector.isValid("A@b.3 ") )
        assertFalse ( detector.isValid("kol ter@gma il.") )
    }

    @Test
    fun testAtSign() {
        assertTrue( detector.isValid("a@a.a") )
        assertFalse( detector.isValid("aa.a") )
        assertFalse( detector.isValid("a.a") )
        assertFalse( detector.isValid("@aa.a") )
        assertFalse( detector.isValid("a@@a.a") )
    }

    @Test
    fun testPeriod() {
        assertTrue( detector.isValid("!@asldkfj.249t8u") )
        assertTrue( detector.isValid("kolter.saurey@test.org") )
        assertTrue( detector.isValid(".@test.org") )
        assertTrue( detector.isValid("....@test.org") )
        assertFalse( detector.isValid("a@.a.a") )
        assertFalse( detector.isValid("a.a") )
        assertFalse( detector.isValid("a.@.a.a") )
        assertFalse( detector.isValid("a...a.a") )
    }

    @Test
    fun testEmptyString() {
        assertFalse { detector.isValid("") }
    }
}