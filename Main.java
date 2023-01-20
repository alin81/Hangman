import java.util.Scanner;
import java.util.Random;
class Main {
  public static void main(String[] args) {
  //IMPORTED CLASSES AND VARIABLES
    Scanner keyboard = new Scanner(System.in);
    Processing processing = new Processing();
    Random random = new Random();
    int loop = 1;
    String word = "";
    int loop2 = 1;
    int choice = 0;

    System.out.println("------------- \n|  Hangman  | \n-------------");
    while (loop==1){
      loop2 = 1;
      choice = 0;
      System.out.println("Would you like to choose a word or proceed with a default word? (1 for Custom, 2 for Default)");
      try {
        choice = Integer.parseInt(keyboard.nextLine());
        } catch (Exception e) {
        System.out.println("Invalid input");
        continue;
        }
      if (choice == 1) {
        //ask for input of custom word
          System.out.println("What word would you like to use?");
          word = keyboard.nextLine();
          for (int i = 0; i < 50; i++) {
            //Clears Console
            System.out.println();
          }
          processing.checkGuess(word);
        }
      else if (choice == 2) {
        //run game with default words
        int s = random.nextInt(8);
        word = processing.defaultWord(s);
        processing.checkGuess(word);
        
      }
      else {
        System.out.println("Invalid Input");
        continue;
      }
    while (loop2 == 1) {
    //Check if user wants to play again
    System.out.println("Would you like to play again? (1 for Yes 2 for No): ");
    choice = Integer.parseInt(keyboard.nextLine());
    if (choice == 1) {
      loop2 = 9;
    } else if (choice == 2) {
      loop = 0;
      loop2 = 0;
    }
    else {
      System.out.println("Invalid input");
      continue;
    }
    }
    }
  }
}