import kotlin.test.Test

class ReminderTest {
    @Test fun testReminderInit(){
        val reminder = Reminder("James")
        assert(reminder.name == "James")
    }

    @Test fun testRemindMe(){
        val reminder = Reminder("James")
        val remindMe = reminder.remindMe()
        assert(remindMe == "walk the dog, James")
    }

    @Test fun testRemindMeDifferentName(){
        val reminder = Reminder("Jon")
        val remindMe = reminder.remindMe()
        assert(remindMe == "walk the dog, Jon")
    }

    @Test fun testRemindTo(){
        val reminder = Reminder("James")
        reminder.remindMeTo("water the plants")
        var result = reminder.remindMe()
        assert(result == "water the plants, James")
    }



}