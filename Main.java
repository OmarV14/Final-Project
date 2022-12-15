import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    System.out.println("\nHello what game would you like to play?");
    System.out.println("\nPress 1 for Tic Tac Toe.\nPress 2 for Rock Paper Scisssors.\nPress 3 to quit."); //prints out option to choose from

    Scanner myObj = new Scanner(System.in);
    int userInput = myObj.nextInt();
    
    do { //start of do/while loop
      if (userInput == 1) {
      System.out.println("\nWelcome to Tic Tac Toe.");
      TTT tttObj = new TTT(); //call to Tic Tac Toe class
      tttObj.ticToe();
      
      System.out.println("\nPress 1 for Tic Tac Toe.\nPress 2 for Rock Paper Scisssors.\nPress 3 to quit.");
      userInput = myObj.nextInt();
    }
    else if (userInput == 2) {
      System.out.println("\nWelcome to Rock Paper Scissors.");
      rpsGame rpsObj = new rpsGame(); //call to Rock, Paper, Scissor class
      rpsObj.rps();
      
      System.out.println("\nPress 1 for Tic Tac Toe.\nPress 2 for Rock Paper Scisssors.\nPress 3 to quit.");
      userInput = myObj.nextInt();
    }
    else if (userInput == 3) { //quit option
      return;
    }
    else { //makes sure input is valid
      System.out.println("\nPlease choose a valid option.");
      userInput = myObj.nextInt();
    }
       } while (userInput != 3);
  }
}