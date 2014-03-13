package exercises


object tests {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(78); 
  println("Welcome to the Scala worksheet");$skip(77); 
	val (positiveNumber,ramdomGenerator) = Exercise1.positiveInt(RNG.simple(1));System.out.println("""positiveNumber  : Int = """ + $show(positiveNumber ));System.out.println("""ramdomGenerator  : exercises.RNG = """ + $show(ramdomGenerator ));$skip(57); 
  println("Our ramdom positive value is"+positiveNumber);$skip(41); val res$0 = 
  Exercise1.positiveInt(ramdomGenerator);System.out.println("""res0: (Int, exercises.RNG) = """ + $show(res$0));$skip(79); 
	val (positiveNumber2,ramdomGenerator2) = Exercise1.positiveInt(RNG.simple(1));System.out.println("""positiveNumber2  : Int = """ + $show(positiveNumber2 ));System.out.println("""ramdomGenerator2  : exercises.RNG = """ + $show(ramdomGenerator2 ));$skip(82); 
	val (positiveNumber3,ramdomGenerator3) = Exercise1.positiveInt(ramdomGenerator2);System.out.println("""positiveNumber3  : Int = """ + $show(positiveNumber3 ));System.out.println("""ramdomGenerator3  : exercises.RNG = """ + $show(ramdomGenerator3 ));$skip(62); 
  //...
  val (nn, rng4) = Exercise1.double(ramdomGenerator3);System.out.println("""nn  : Double = """ + $show(nn ));System.out.println("""rng4  : exercises.RNG = """ + $show(rng4 ));$skip(57); 
  
  val ((ii,dd), rng5) = Exercise1.intDoublePair(rng4);System.out.println("""ii  : Int = """ + $show(ii ));System.out.println("""dd  : Double = """ + $show(dd ));System.out.println("""rng5  : exercises.RNG = """ + $show(rng5 ));$skip(53); 
 val (l, nextRng) = Exercise1.ints(5)(RNG.simple(5));System.out.println("""l  : List[Int] = """ + $show(l ));System.out.println("""nextRng  : exercises.RNG = """ + $show(nextRng ));$skip(18); val res$1 = 

 nextRng.nextInt;System.out.println("""res1: (Int, exercises.RNG) = """ + $show(res$1))}
  
}
