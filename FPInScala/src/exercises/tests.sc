package exercises


object tests {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
	val (positiveNumber,ramdomGenerator) = Exercise1.positiveInt(RNG.simple(1))
                                                  //> positiveNumber  : Int = 384748
                                                  //| ramdomGenerator  : exercises.RNG = exercises.RNG$$anon$1@38dda25b
  println("Our ramdom positive value is"+positiveNumber)
                                                  //> Our ramdom positive value is384748
  Exercise1.positiveInt(ramdomGenerator)          //> res0: (Int, exercises.RNG) = (1151252339,exercises.RNG$$anon$1@3b835282)
	val (positiveNumber2,ramdomGenerator2) = Exercise1.positiveInt(RNG.simple(1))
                                                  //> positiveNumber2  : Int = 384748
                                                  //| ramdomGenerator2  : exercises.RNG = exercises.RNG$$anon$1@2a9df354
	val (positiveNumber3,ramdomGenerator3) = Exercise1.positiveInt(ramdomGenerator2)
                                                  //> positiveNumber3  : Int = 1151252339
                                                  //| ramdomGenerator3  : exercises.RNG = exercises.RNG$$anon$1@67d225a7
  //...
  val (nn, rng4) = Exercise1.double(ramdomGenerator3)
                                                  //> nn  : Double = 0.2558267895392267
                                                  //| rng4  : exercises.RNG = exercises.RNG$$anon$1@15a62c31
  
  val ((ii,dd), rng5) = Exercise1.intDoublePair(rng4)
                                                  //> ii  : Int = 1612966641
                                                  //| dd  : Double = 0.4113903466665141
                                                  //| rng5  : exercises.RNG = exercises.RNG$$anon$1@4ce32802
 val (l, nextRng) = Exercise1.ints(5)(RNG.simple(5))
                                                  //> l  : List[Int] = List(1923744, -1478223346, 832832900, 735168418, -209115454
                                                  //| 7)
                                                  //| nextRng  : exercises.RNG = exercises.RNG$$anon$1@23d256fa

 nextRng.nextInt                                  //> res1: (Int, exercises.RNG) = (-1478223346,exercises.RNG$$anon$1@464c4975)
  
}