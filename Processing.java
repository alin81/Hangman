import java.util.Scanner;
import java.util.Arrays;
class Processing {
  public String defaultWord (int s) {
    //Chooses a default word from the word bank
    String defaultWords[] = {"word", "thing", "fire", "keyboard", "phone", "loop", "large", "hunger"};
    String a = defaultWords[s];
    return a;
  }
  public String hangmanBody(int s) {
    //Prints the hangman
    String hangman = "";
    if (s == 0) {
      hangman = "  +---+\n  |   |\n      |\n      |\n      |\n      |\n=========";
    }
    else if (s == 1) {
      hangman = "  +---+\n  |   |\n  O   |\n      |\n      |\n      |\n=========";
    }
    else if (s == 2) {
      hangman = "  +---+\n  |   |\n  O   |\n  |   |\n      |\n      |\n=========";
    }
    else if (s == 3) {
      hangman = "  +---+\n  |   |\n  O   |\n /|   |\n      |\n      |\n=========";
    }
    else if (s == 4) {
      hangman = "  +---+\n  |   |\n  O   |\n /|\\  |\n      |\n      |\n=========";
    }
    else if (s == 5) {
      hangman = "  +---+\n  |   |\n  O   |\n /|\\  |\n /    |\n      |\n=========";
    }
    else if (s == 6) {
      hangman = "  +---+\n  |   |\n  O   |\n /|\\  |\n / \\  |\n      |\n=========";
    }
    return hangman;  
  }
  public void checkGuess(String word) {
    Scanner keyboard = new Scanner(System.in);
    String guess = "";
    String[] arr = word.split("");
    String[] arr1 = new String[word.length()];
    int win = 0;
    int loop = 1;
    int correctCount = 0;
    int errorCount = 0;

    
    for (int i = 0; i<word.length(); i++){
      arr1[i] = "_";
    }
    while (loop==1){
    System.out.print("Guess: ");
    guess = keyboard.nextLine().toLowerCase();
    correctCount = 0;
    for (int i = 0; i < word.length(); i++) {
      String letter = arr[i];
      //Checks user's guess
      if (letter.equals(guess)) {
        arr1[i] = arr[i];
        correctCount++;
      } else if (guess.equals(word)){
        System.out.println("You win!");
        win = 1;
        loop = 0;
        break;
      }
    }
    
    if (correctCount == 0){
      //Checks for a correct guess
      errorCount++;
    }
    for (int i = 0; i< word.length(); i++){
      if (win == 0) {
        System.out.print(arr1[i]);
      }
    }
    System.out.println("");
    if (loop == 1){
      System.out.println(hangmanBody(errorCount));
    }
    if (errorCount>=6){
      loop = 0;
      System.out.println("You lose");
      System.out.println("The word was " + word);
    } 
    if (Arrays.equals(arr, arr1)) {
      System.out.println("You Win!");
      loop = 0;
    }
    }
  }
}