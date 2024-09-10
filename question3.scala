class Account(private var balanceAmount: Double) {

  def deposit(amount: Double): Unit = {
    if (amount > 0) {
      balanceAmount += amount
    } else {
      println("Error: Deposit amount must be positive")
    }
  }

  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balanceAmount) {
      balanceAmount -= amount
    } else {
      if (amount > 0) println("Error: Insufficient funds")
      else println("Error: Withdrawal amount must be positive")
    }
  }

  def transfer(amount: Double, recipientAccount: Account): Unit = {
    if (amount > 0 && amount <= balanceAmount) {
      this.withdraw(amount)
      recipientAccount.deposit(amount)
    } else {
      if (amount > 0) println("Error: Insufficient funds for transfer")
      else println("Error: Transfer amount must be positive")
    }
  }

  def checkBalance: Double = balanceAmount

  override def toString: String = f"Account(balance: Rs.$$${balanceAmount}%.2f)"
}

object BankingApp {
  def main(args: Array[String]): Unit = {
    val userAccount1 = new Account(1200.00)
    val userAccount2 = new Account(700.00)

    println(s"Initial balance of Account 1: ${userAccount1}")
    println(s"Initial balance of Account 2: ${userAccount2}")

    userAccount1.deposit(350.00)
    println(s"After depositing Rs.350 into Account 1: ${userAccount1}")

    userAccount1.withdraw(200.00)
    println(s"After withdrawing Rs.200 from Account 1: ${userAccount1}")

    userAccount1.transfer(400.00, userAccount2)
    println(s"After transferring Rs.400 from Account 1 to Account 2:")
    println(s"Account 1: ${userAccount1}")
    println(s"Account 2: ${userAccount2}")
  }
}