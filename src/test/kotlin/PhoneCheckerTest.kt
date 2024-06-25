import kotlin.test.Test

class TestPhoneChecker {
    @Test fun testNumberTooShort(){
        val phoneChecker = PhoneChecker()
        val result = phoneChecker.isPhoneValid("07898")
        assert(result == false)
    }

    @Test fun testNumberTooLong(){
        val phoneChecker = PhoneChecker()
        val result = phoneChecker.isPhoneValid("0789800000000000000000000")
        assert(result == false)
    }

    @Test fun testNumberValid(){
        val phoneChecker = PhoneChecker()
        val result = phoneChecker.isPhoneValid("07933555555")
        assert(result == true)
    }

    @Test fun testLetterInStringReturnsFalse(){
        val phoneChecker = PhoneChecker()
        val result = phoneChecker.isPhoneValid("0a999888777")
        assert(result == false)
    }

}