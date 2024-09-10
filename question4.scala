class Wallet(private var balanceAmount: Double) {

  def deposit(amount: Double): Unit = {
    if (amount > 0) {
      balanceAmount += amount
    } else {
      println("Error: Deposit value should be positive")
    }
  }

  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balanceAmount) {
      balanceAmount -= amount
    } else {
      if (amount > 0) println("Error: Not enough funds")
      else println("Error: Withdrawal value should be positive")
    }
  }

  def transfer(amount: Double, recipientWallet: Wallet): Unit = {
    if (amount > 0 && amount <= balanceAmount) {
      this.withdraw(amount)
      recipientWallet.deposit(amount)
    } else {
      if (amount > 0) println("Error: Not enough funds to transfer")
      else println("Error: Transfer value should be positive")
    }
  }

  def getBalance: Double = balanceAmount

  override def toString: String = f"Wallet(balance: $$${balanceAmount}%.2f)"
}

class Bank(accounts: List[Wallet]) {

  def findNegativeBalances: List[Wallet] = {
    accounts.filter(_.getBalance < 0)
  }

  def calculateTotalBalance: Double = {
    accounts.map(_.getBalance).sum
  }

  def applyInterestRates(): Unit = {
    accounts.foreach { acc =>
      val bal = acc.getBalance
      if (bal > 0) {
        acc.deposit(bal * 0.05)
      } else {
        acc.deposit(bal * 0.10)
      }
    }
  }
}

object BankingSystem {
  def main(args: Array[String]): Unit = {
    val wallet1 = new Wallet(1000.00)
    val wallet2 = new Wallet(500.00)
    val wallet3 = new Wallet(-200.00)
    val bank = new Bank(List(wallet1, wallet2, wallet3))

    println("Initial Account Balances:")
    println(s"Wallet1: ${wallet1}")
    println(s"Wallet2: ${wallet2}")
    println(s"Wallet3: ${wallet3}")

    println("\nWallets with Negative Balances:")
    bank.findNegativeBalances.foreach(println)

    println("\nTotal Balance of all Wallets:")
    println(f"Rs.${bank.calculateTotalBalance}%.2f")

    println("\nApplying Interest Rates...")
    bank.applyInterestRates()

    println("\nBalances after Interest Application:")
    println(s"Wallet1: ${wallet1}")
    println(s"Wallet2: ${wallet2}")
    println(s"Wallet3: ${wallet3}")
  }
}