package exercises

trait RNG {
  def nextInt: (Int, RNG) 
}


object RNG {
  def simple(seed: Long): RNG = new RNG {
    def nextInt = {
      val seed2 = (seed*0x5DEECE66DL + 0xBL) & ((1L << 48) - 1)
      ((seed2 >>> 16).asInstanceOf[Int], simple(seed2))
    }
  }
}

object Exercise1 {
  
  def positiveInt(rng: RNG): (Int, RNG) = {
    val (randomValue,ramdomGenerator) = rng.nextInt
    if (randomValue == Int.MinValue)
      positiveInt(ramdomGenerator)
    else 
      (randomValue.abs,ramdomGenerator)
  }
  
  def double(rng:RNG): (Double,RNG) ={
    val (posInt, otherRng) = positiveInt(rng)
    val result = posInt.toDouble/Int.MaxValue
    if (result == 1)
    	double(otherRng)
    else
    	(result,otherRng)
  }
  
  def intDoublePair(rng: RNG) : ((Int, Double), RNG) = {
    
    val(nextInt, nextRng) = rng.nextInt
    val (nextDouble, finalRng) = double(nextRng)
   
    ((nextInt, nextDouble), finalRng)
  }
  
  def ints(count: Int)(rng: RNG): (List[Int], RNG) = {
    
    if(count == 0) 
      (List(), rng)
    else {
      val (ii, nextRng) = rng.nextInt
      val (randomList, lastRng) = ints(count -1)(nextRng)
      (ii :: randomList, lastRng)
    } 
  }
}