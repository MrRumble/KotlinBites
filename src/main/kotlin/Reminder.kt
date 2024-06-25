class Reminder(
    val name: String,
    var reminder: String = ""
    ) {
    fun remindMe(): String{
        return this.reminder + ", " + this.name
    }

    fun remindMeTo(string: String): Unit{
        this.reminder = string
    }
}