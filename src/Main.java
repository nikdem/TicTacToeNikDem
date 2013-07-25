import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
		System.out.println("Hello! This is a game of \"Tic Tac Toe\"");
		
		System.out.println("Enter the name of the X-player:");
		Scanner sc = new Scanner(System.in);
		String imya = sc.nextLine();
		Gamer gamerX = new Gamer(imya, 1);
		
		System.out.println("Enter the name of the O-player:");
		imya = sc.nextLine();
		Gamer gamerO = new Gamer(imya, 0);	
		
		Board board = new Board();
		board.showBoard();
		
		Game game = new Game();
		while(true) {
			game.inputCoordinates(gamerX, board);
			board.showBoard();
			if(game.validationWin(board, 'x') == "three") {
				System.out.println("Win " + gamerX.getName() + "!");
				break;
		        } else	if(game.validationWin(board, 'x') == "draw") {
				System.out.println("Draw!");
				break;
			}	
			
			game.inputCoordinates(gamerO, board);
			board.showBoard();
			if(game.validationWin(board, 'o') == "three") {
				System.out.println("Win " + gamerO.getName() + "!");
				break;
			} else if(game.validationWin(board, 'o') == "draw") {
				System.out.println("Draw!");
				break;
			}			
	    }

	}
}
