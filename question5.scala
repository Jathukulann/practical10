object LetterCounter {
  def countLetters(wordList: List[String]): Int = {
    val wordLengths = wordList.map(_.length)
    
    val totalLetters = wordLengths.reduce(_ + _)
    
    totalLetters
  }

  def main(args: Array[String]): Unit = {
    val words = List("apple", "banana", "cherry", "date")
    val letterCount = countLetters(words)
    println(s"Total count of letters: $letterCount")
  }
}