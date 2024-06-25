class FizzBuzz() {
    fun fizzBuzz(number: Int): String{
        if (number % 5 == 0 && number % 3 == 0) {
            return "FizzBuzz"
        }
        if (number % 3 == 0){
            return "Fizz"
        }
        if (number % 5 == 0){
            return "Buzz"
        }
        return "$number"
    }

    fun fizzBuzzStringified(number: Int): String{
        var counter = 1
        var finalString = ""
        while (counter <= number){
            finalString += fizzBuzz(counter) + ", "
            counter += 1
        }
        return finalString.dropLast(2)
    }
}