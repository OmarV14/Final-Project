import java.util.Scanner;

public class rpsGame {
  public void rps(){
    Scanner scanner = new Scanner(System.in);
    String compChoice;
    
    System.out.println("\nChoose rock, paper, or scissors. Press q to quit.");
    String userMove = scanner.nextLine();

    if (userMove.equals("q")) { //option to quit
        return;
    }
      else { 
      while(true) { //loop to continue game
        if (!userMove.equals("rock") && !userMove.equals("paper") && !userMove.equals("scissors") && !userMove.equals("q")) {
      System.out.println("Invalid input");
      }
        
          int computer = (int)(Math.random()*3); //Computer choosing random option
      if (computer == 0) {
      compChoice = "rock";
      }
      else if (computer == 1) {
        compChoice = "paper";
      }
      else {
        compChoice = "scissors";
      }
        
       if (userMove.equals(compChoice)) { //game conditions
         System.out.println("Computer chose " + compChoice + ".");
         System.out.println("It's a tie.");
       }
        else if ((userMove.equals("rock") && compChoice.equals("paper")) || (userMove.equals("paper") && compChoice.equals("scissors")) || userMove.equals("scissors") && compChoice.equals("rock")) {
          System.out.println("Computer chose " + compChoice + ".");
          System.out.println("You lose.");
        }
        else if ((userMove.equals("rock") && compChoice.equals("scissors")) || (userMove.equals("paper") && compChoice.equals("rock")) || userMove.equals("scissors") && compChoice.equals("paper")){
          System.out.println("Computer chose " + compChoice + ".");
          System.out.println("You win!");
        }
        else if (userMove.equals("q")) {
        return;
    }


        System.out.println("\nChoose rock, paper, or scissors. Press q to quit.");//option to quit
        userMove = scanner.nextLine();
    
      }//while loop end
        
    }
    
    

    
  }
}