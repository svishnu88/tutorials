import scala.math._
val num = 3.14
val fun = ceil _

fun(num)

fun(10.0)

Array(3.14, 1.42, 2.0).map(fun)


//Anonymous Functions

(x: Double) => 3 * x

val triple = (x: Double) => 3 * x

Array(3.14, 1.42, 2.0).map(triple)

Array(3.14, 1.42, 2.0).map((x: Double) => 3 * x)

Array(3.14, 1.42, 2.0) map { (x: Double) => 3 * x} //_ each element of the collection

//Functions with function parameters

def valueAtOneQuarter(f: (Double) => Double) = f(0.25)
valueAtOneQuarter(ceil _)
valueAtOneQuarter(sqrt _)
def mulBy(factor : Double) = (x : Double) => factor * x
val quintuple = mulBy(5)
quintuple(20)
//Parameter Inference

valueAtOneQuarter((x: Double) => 3 * x)
valueAtOneQuarter((x) => 3 * x)
valueAtOneQuarter(x => 3 * x)
valueAtOneQuarter(3 * _)
//val fun = 3 * _ // Error: Can’t infer types
val tempfun = 3 * (_: Double) // OK
val tempfun1: (Double) => Double = 3 * _ // OK

//Useful Higher Order Functions

(1 to 9).map(0.1 * _)
(1 to 9).map("*" * _).foreach(println _)

(1 to 9).filter(_ % 2 == 0)
(1 to 9).reduceLeft(_ * _)
"Mary had a little lamb".split(" ").sortWith(_.length < _.length)
//Closures
val triple1 = mulBy(3)
val half = mulBy(0.5)
println(triple1(14) + " " + half(14))

(1 to 9).map(0.1 * _)



(1 to 9).map("*" * _).foreach(println)
"I am an Indian and learning Spark".split(" ").sortWith(_.length<_.length)
