case class Address(city: String, postcode: String)
case class Person(age: Int, address: Address)

trait Getter[A, B]{
  def get(from: A): B
}

trait Setter[A,B] {
  def set(from: A, updatedField: B): A
}

object Setter {
  def compose[A, B, C](aToBLens: Lens[A, B], bToC: Setter[B, C]): Setter[A, C] =  new Setter[A, C] {
    def set(from: A, updatedField: C): A = {
      val b = aToBLens.get(from)
      val newB = bToC.set(b, updatedField )
      aToBLens.set(from, newB)
    }
  }
}

trait Lens[A,B] extends Getter[A,B] with Setter[A, B] {

  def >-[C](other: Lens[B,C]): Lens[A,C] = Lens.compose(this, other)
}


object Lens {
  def compose[A, B, C](aToBLens: Lens[A, B], bToC: Lens[B, C]): Lens[A, C] =  new Lens[A, C] {
    def get(from: A): C = bToC.get(aToBLens.get(from))

    def set(from: A, updatedField: C): A = {
      val b = aToBLens.get(from)
      val newB = bToC.set(b, updatedField )
      aToBLens.set(from, newB)
    }
  }
}


object AddressLens extends Lens[Person, Address] {
  def get(from: Person): Address = from.address

  def set(from: Person, updatedField: Address): Person = from.copy(address = updatedField)
}


object CityLens extends Lens[Address, String] {

  def get(from: Address): String = from.city

  def set(from: Address, updatedField: String): Address = from.copy(city = updatedField)
}

object Test extends App {
  val address = Address("London", "EC1...")
  val person = Person(25, address)

  //basic scala
  println(person.copy(address = person.address.copy(city = "Paris")))

  val Person2City= AddressLens >- CityLens

  println(Person2City.set(person, "Paris") )
  println(Person2City.get(person))

  // potentially  AddressLens >- CityLens >- Mayor >- DateOfBirth >- Month

  // get address a of my person p
  // update city of address a => a2
  // update address of person p => p2

}