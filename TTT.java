import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class TTT {

  static ArrayList<Integer> userPlacement = new ArrayList<Integer>(); //arraylist for positions of player and cpu
  static ArrayList<Integer> cpuPlacement = new ArrayList<Integer>();

  
  public void ticToe() {
    
    Scanner sc = new Scanner(System.in);
    
    int userPos;
    
    
    char [] [] board = {{' ', '|', ' ', '|', ' '}, //board game
                       {'-', '|', '-', '|', '-'}, 
                       {' ', '|', ' ', '|', ' '},
                       {'-', '|', '-', '|', '-'}, 
                       {' ', '|', ' ', '|', ' '}};

    gameBoard(board);
    
    
    while (true) { //loop to continue game
      System.out.println("\nChoose a number 1-9 (1 being top left and 9 being bottom right).\n");
      userPos = sc.nextInt();
      while (userPlacement.contains(userPos) || cpuPlacement.contains(userPos) || cpuPlacement.contains(userPlacement)) { //checks if position is taken
        System.out.println("Unable to place there. Try again.");
          userPos = sc.nextInt();
        while(userPlacement.contains(userPos) || cpuPlacement.contains(userPos)){ //checks if position is taken
          System.out.println("Unable to place there. Try again.");
          userPos = sc.nextInt();        
      }
      }

      placement(board, userPos, "player"); //switches empty space for player selection
      
      String result = winner(); //checks if player has won
      if (result.length() > 0) {
        System.out.println(result);
        break;
      }

    Random rand = new Random(); //chooses random space for cpu
    int cpuPos = rand.nextInt(9) + 1;
      while(userPlacement.contains(cpuPos) || cpuPlacement.contains(cpuPos)) { //checks if position is taken
        cpuPos = rand.nextInt(9) + 1;
      }
    placement(board, cpuPos, "cpu"); //switches empty space with selection

    gameBoard(board); //Print the board with spaces switched
      
    result = winner(); //checks if cpu has won
      if (result.length() > 0) {
        System.out.println(result);
        break;
      }
    
    }
    

    
  }
  
  public static void gameBoard (char[][] board) { //method to print out board
    for (char[] row : board) {
      for (char x : row) {
        System.out.print(x);
      }
      System.out.println();
    }
  }
  
  public static void placement(char[][] board, int pos, String user) { //method to switch empty spaces

    char symbol = ' ';
    
    if (user.equals("player")) {
      symbol = 'O';
      userPlacement.add(pos);
    } 
    else if (user.equals("cpu")) {
      symbol = 'X';
      cpuPlacement.add(pos);
    }
      
    switch(pos) {
      case 1:
        board[0][0] = symbol;
        break;
      case 2:
        board[0][2] = symbol;
        break;
      case 3:
        board[0][4] = symbol;
        break;
      case 4:
        board[2][0] = symbol;
        break;
      case 5:
        board[2][2] = symbol;
        break;
      case 6:
        board[2][4] = symbol;
        break;
      case 7:
        board[4][0] = symbol;
        break;
      case 8:
        board[4][2] = symbol;
        break;
      case 9:
        board[4][4] = symbol;
        break;
      default:
        break;
    }
  }
  
  public static String winner() { //method to check winner

    List topRow = Arrays.asList(1,2,3);
    List midRow = Arrays.asList(4,5,6);
    List botRow = Arrays.asList(7,8,9);
    List leftC = Arrays.asList(1,4,7);
    List midC = Arrays.asList(2,5,8);
    List rightC = Arrays.asList(3,6,9);
    List dig1 = Arrays.asList(1,5,9);
    List dig2 = Arrays.asList(7,5,3);

    List<List> win = new ArrayList<List>();
    win.add(topRow);
    win.add(midRow);
    win.add(botRow);
    win.add(leftC);
    win.add(midC);
    win.add(rightC);
    win.add(dig1);
    win.add(dig2);

    for (List l : win) {
      if (userPlacement.containsAll(l)) {
        return "You win!";
      }
      else if (cpuPlacement.containsAll(l)) {
        return "You lose.";
      }
      else if(userPlacement.size() + cpuPlacement.size() == 9){
        return "Tie.";
      }
    }
      
    return "";
  }
}