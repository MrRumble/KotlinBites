class ShoppingCart(
    val items: ArrayList<Item> = ArrayList()
) {
    fun getTotalPrice(): Double{
        var total = 0.0
        for (item in this.items){
            total += item.price
        }
        return total
    }

    fun addItem(item: Item): Unit{
        this.items.add(item)
    }

}