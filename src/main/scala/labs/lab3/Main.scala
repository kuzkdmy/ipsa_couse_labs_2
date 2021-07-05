package labs.lab3

object Main extends App {

  val item1 = new Item("item1", 3, BigDecimal.valueOf(11111.1d))
  val item2 = new Item("item2", 4, BigDecimal.valueOf(22222.2d))
  val item3 = new Item("item2", 4, BigDecimal.valueOf(22222.2d))

  println(s"item1 $item1")
  println(s"item1 +  10  ${item1 + 10}")
  println(s"item1 ++ 10 (see we are mutable state)  ${item1 ++ 10}")
  println(s"item1 < item2 ${item1 < item2}")
  println(s"item1 == item2 ${item1 == item2}")
  println(s"item2 == item3 ${item3 == item3}")

  // intentionally java style with vars, and not a case class
  class Item(var name: String, var count: Int, var price: BigDecimal) {
    def +(plusCount: Int): Item = {
      count += plusCount
      this
    }
    def ++(plusCount: Int): Item =
      this + plusCount
    def <(other: Item): Boolean =
      price < other.price
    def ==(other: Item): Boolean =
      name == other.name && count == other.count && price == other.price

    override def equals(other: Any): Boolean =
      other match {
        case that: Item => that == this
        case _          => false
      }
    override def hashCode(): Int = {
      val state = Seq(name, count, price)
      state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
    }
    override def toString = s"Item(name=$name, count=$count, price=$price)"
  }
  class ItemSupplier(
      var name: String,
      var country: String,
      var phone: String
  ) {}
}
