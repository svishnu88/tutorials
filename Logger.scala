package day4.scala.functionalprogramming

/**
 * Created by vishnu on 09/08/15.
 */
trait Logged {

  def log(msg: String) { }//abstract
  def info(msg:String) {log("INFO: " +msg)}
  def warn(msg:String) {log("WARN: " +msg)}
  def severe(msg:String) {log("SEVERE: " +msg)}


}

trait ConsoleLogger extends Logged {
  override def log(msg: String) { println(msg) } //implement or Concrete function
}

trait ShortLogger extends Logged {
  val maxLength: Int // An abstract field
  abstract override def log(msg: String) {
    super.log(
      if (msg.length <= maxLength) msg else msg.substring(0, maxLength - 3) + "...")
  }
}

trait TimeStampLogger extends Logged {
  abstract override def log(msg:String): Unit ={
    super.log(new java.util.Date() + " " + msg)
  }
}
class Account {
  protected var balance = 0.0
}

class SavingsAccount extends Account with Logged {
  var interest = 0.0
  def withdraw(amount: Double) {
    if (amount > balance) warn("Insufficient funds @ given point of time @ today")
    else balance -= amount
  }

  // More methods ...
}

object Main extends App {
  val acct = new SavingsAccount with ConsoleLogger with TimeStampLogger with ShortLogger {
    val maxLength = 15
  }
  acct.withdraw(100)
  // Log message is not truncated because maxLength is 20
}

