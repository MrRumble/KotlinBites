import kotlin.reflect.typeOf
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.server.Undertow
import org.http4k.server.asServer

fun main(args: Array<String>) {

    println("Program arguments: ${args.joinToString()}")
    println("Hello World")

    val message: String = "String to reverse"
    val messageReverse = message.reversed()
    println(messageReverse)

    var aNumber = 2 //Val is immutable, switched to var to make code work
    aNumber = 4
    println(aNumber)

    // Here, a list of strings, potentially containing
    // null elements. Added ? to the end of Number
    val numbers: List<Number?> = listOf(3, 4, null)
    println(numbers)


    val otherNames: List<String?> = listOf("Kat", "Marc", null)
    // Loop on each name in the list
    for (name in otherNames) {
        // Print the length
        if (name != null) {
            println(name.length)
        }
    }

    //kotlin uses as notation for type casting. COnvert an object from one type to another.
    //So below we are converting the string "3" to an integer
//    val number = "3" as Int
    // This wont work becuase you cannot directly convert a string to an integer
    //use:
    val number = "3".toInt()
    println(number)

//   How to fix the following code so we can create a list of both strings and numbers?
    val listOfThings: List<Any> = listOf(3, "Hello", 4, "4")
    val listOfStrings: ArrayList<String> = ArrayList()
    val listOfInts: ArrayList<Int> = ArrayList()

    for (item in listOfThings){
        listOfStrings.add(item.toString())
    }

    for (item in listOfThings) {
        try{
            listOfInts.add(item.toString().toInt())
        } catch (e: NumberFormatException){
            println("$item not in the right format")
            }
        }
    println(listOfStrings)
    println(listOfInts)

    // When creating a function in Kotlin you need to specify the type of any parameters
    // and the type of what will be returned.
    // If the function is not returning anything its type is Unit

    //    1
    //    Write a method called superify which takes a string and adds the word "super" to the start.
    //    So given 'woman' it returns 'superwoman', given 'dog' it returns 'superdog'.

    fun superify (word: String): String{
        return "super$word"
    }
    println(superify("rumble"))

    //2
    //Define a function revealSecret which takes a passcode in argument,
    // and returns a secret string "The cookies are in the desk drawer"
    // only if the given passcode is the string "HUNGRY".
    //
    //If the given passcode is something else, the function should return null.

    fun revealSecret (passcode: String): String?{
        if (passcode == "HUNGRY"){
            return "The cookies are in the desk drawer"
        }
        return null
        }
    println(revealSecret("HUNGRY"))
    println(revealSecret("WrongPassword"))

    // Define a function getNumberSign that takes a number and returns a
    // String which is either "zero", "positive" or "negative" depending on its sign.
    // If the argument is not a number, the function should return null.

    fun getNumberSign(number: Int): String {
        return when {
                number > 0 -> "positive"
                number < 0 -> "negative"
                else -> "zero"
            }
        }
    println(getNumberSign(3))
    println(getNumberSign(-3))
    println(getNumberSign(0))

//    1
//    Define a function printHelloMessages which,
//    for each name in the list given in argument,
//    prints a hello message. You should use map in this function.

    fun printHelloMessages(names: List<String>){
        names.map{name -> println("Hello $name!")
        }
    }
    println(printHelloMessages(listOf("John", "James", "Wayne")))

    //Use the function getNumberSign written in the previous section.
    // Write a new function getAllNumberSigns which takes an array of numbers (Int),
    // and returns an array of the corresponding number signs.

    fun getAllNumberSigns(numbers: List<Int>): List<String>{
        return numbers.map{number -> getNumberSign(number)
        }
    }
    println(getAllNumberSigns(listOf(4, -12, 0, 1)))


    //FUNCTIONS PART 2

    //In Kotlin, functions can be considered as values (like numbers, strings, etc)
    // , which means they also have their own type.

//    Higher-order functions
//    A function can take other functions as arguments.
//    Here is an example. Try to run the following code in a Kotlin file.

    fun calculate(a: Int, b: Int, calculateFunction: (Int, Int) -> Int): Int {
        return calculateFunction(a, b)
    }

    fun add(a: Int, b: Int): Int {
        return a + b
    }

    fun multiply(a: Int, b: Int): Int {
        return a * b
    }
    // We're not calling the function
    // but referencing it, so we need to use
    // `::` in front of their name.
    calculate(2, 3, ::add) // 2 + 3 = 5
    calculate(2, 4, ::multiply) // 2 * 4 = 8
    //   EXERCISES:
    //    Implement a function convertToCaps which takes a string and returns the string converted to capital letters.

    fun convertToCaps(lowerString: String): String{
        return lowerString.uppercase()
    }
    println(convertToCaps("converted to caps"))

    //    Implement a function exclaim which takes a string and returns the given string with an exclamation mark at the end.

    fun exclaim(exclaimMe: String): String{
        return "$exclaimMe!"
    }
    println(exclaim("exclaim this"))

    //    Implement a function greetWith which we can call this way:
    fun greetWith(name: String, stringFunction: (String) -> String): String{
        return stringFunction(name)
    }
    println(greetWith("rumble", ::exclaim))
    println(greetWith("rumble", ::convertToCaps))

    //Exercise
    //Call the previous function greetWith using a lambda instead of a named function.
    val greetJames = greetWith("James"){ name -> "$name!"}
    val capitaliseMe = greetWith("make me uppercase"){name -> name.uppercase()}
    println(greetJames + " " + capitaliseMe)

    // CLASSES
    // Classes in Kotlin work similiar to every other language.
    // We use it to create a blueprint for to create objects with properties
    // and behaviour
    //DATA CLASSES: Sometimes we need to create a class just to store data, without any logic inside
    data class User(val email: String, val name: String) {
        // Empty
    }
    val user = User("kat@myemail.org", "Kat")
    val otherUser = User("james@myemail.org", "James")

    //The best practice is often to put each file in its own file. For example,
    // classes DiaryEntry and Diary would go in files named DiaryEntry.kt and Diary.kt.
    //
    //Note that because all source files are compiled together, there is no need to "require" or
    // "load" other files from the main file.

    //Exercise
    //Write two classes Item and ShoppingCart
    // (in their separate files) so the following code works:
    val item = Item("Mars", 4.99)

    item.name // 'Mars'
    item.price // 4.99

    val cart = ShoppingCart()
    cart.getTotalPrice() // 0.0

    cart.addItem(item)

    cart.getTotalPrice() // 4.99

    cart.addItem(Item("Skittle", 3.99))
    cart.addItem(Item("Skittle", 3.99))

    cart.getTotalPrice() // 12.97

    val app = { request: Request ->
        Response(Status.OK)
            .body("Hello, ${request.query("name")}!")
    }

    app.asServer(Undertow(9000)).start()

}







