import kotlin.test.Test

class FizzBuzzTest {

    @Test
    fun testFizzBuzzOneReturnsOne(){
        val fizzBuzz = FizzBuzz()
        assert(fizzBuzz.fizzBuzz(1) == "1")
    }
    @Test
    fun testFizzBuzzTwoReturnsOne(){
        val fizzBuzz = FizzBuzz()
        assert(fizzBuzz.fizzBuzz(2) == "2")
    }
    @Test
    fun testFizzBuzzThreeReturnsFizz(){
        val fizzBuzz = FizzBuzz()
        assert(fizzBuzz.fizzBuzz(3) == "Fizz")
    }
    @Test
    fun testFizzBuzzSixReturnsFizz(){
        val fizzBuzz = FizzBuzz()
        assert(fizzBuzz.fizzBuzz(6) == "Fizz")
    }
    @Test
    fun testFizzBuzzFiveReturnsBuzz(){
        val fizzBuzz = FizzBuzz()
        assert(fizzBuzz.fizzBuzz(5) == "Buzz")
    }
    @Test
    fun testFizzBuzzTenReturnsBuzz(){
        val fizzBuzz = FizzBuzz()
        assert(fizzBuzz.fizzBuzz(10) == "Buzz")
    }
    @Test
    fun testFizzFifteenTenReturnsFizzBuzz(){
        val fizzBuzz = FizzBuzz()
        assert(fizzBuzz.fizzBuzz(15) == "FizzBuzz")
    }
    @Test
    fun testFizzThirtyReturnsFizzBuzz(){
        val fizzBuzz = FizzBuzz()
        assert(fizzBuzz.fizzBuzz(30) == "FizzBuzz")
    }
    @Test
    fun testFizzBuzzStringToThree(){
        val fizzBuzz = FizzBuzz()
        val result = fizzBuzz.fizzBuzzStringified(3)
        assert(result == "1, 2, Fizz")
    }
    @Test
    fun testFizzBuzzStringToFive(){
        val fizzBuzz = FizzBuzz()
        val result = fizzBuzz.fizzBuzzStringified(5)
        println(result)
        assert(result == "1, 2, Fizz, 4, Buzz")
    }


}