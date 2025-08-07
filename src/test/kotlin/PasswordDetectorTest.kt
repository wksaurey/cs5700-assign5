import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PasswordDetectorTest {
    val detector = PasswordDetector()

    @Test
    fun testValidPasswords() {
        val validPasswordStrings = mutableListOf<String>(
            "aaaaaa!A",
            "A!@#$%^&*()0",
            "A!@#$%^&*()0a",
            "1234567*9J",
            "asdpoihj;loikjasdf;ijp;lij2309jasd;lfkm20ij@aH",
        )
        for (validPasswordString in validPasswordStrings) {
            assertTrue( detector.isValid(validPasswordString), "The value $validPasswordString failed" )
        }
    }

    @Test
    fun testEndsWithSpecial() {
        assertFalse (detector.isValid("aaaaaa!A!") )
        assertFalse (detector.isValid("A!@#$%^&*()!") )
        assertFalse (detector.isValid("1234567*9J!") )
        assertFalse (detector.isValid("asdpoihj;loikjasdf;ijp;lij2309jasd;lfkm20ij@aH!") )
    }

    @Test
    fun testMissingCapital() {
        assertFalse (detector.isValid("aaa!!!aaa") )
        assertFalse (detector.isValid("!@#$%^&*().") )
        assertFalse (detector.isValid("1234567*9") )
        assertFalse (detector.isValid("asdpoihj;loikjasdf;ijp;lij2309jasd;lfkm20ij@a") )
    }

    @Test
    fun testMissingSpecial() {
        assertFalse (detector.isValid("aaaaaaaA") )
        assertFalse (detector.isValid("AbcDefgh") )
        assertFalse (detector.isValid("12345679J") )
        assertFalse (detector.isValid("asdpoihjloikjasdfijplij2309jasdlfkm20ijaH") )
    }

    @Test
    fun testTooShort() {
        assertFalse ( detector.isValid("A!") )
        assertFalse ( detector.isValid("He!!0") )
        assertFalse ( detector.isValid("He!!0aa") )
    }


    @Test
    fun testEmptyString() {
        assertFalse { detector.isValid("") }
    }
}