import java.io.PrintStream;

public class Main {
  public static void main(String[] args) {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException ex) {
            System.err.println("Unsupported encoding set for console: ");
        }

		System.out.println("Привет! Это игра \"Крестики-Нолики\"");

        Gamer gamerX = new Gamer('X');
        Gamer gamerO = new Gamer('O');
		
		Board board = new Board();
		board.showBoard();
		
		Game game = new Game();
		while(true) {
			game.inputCoordinates(gamerX, board);
			board.showBoard();
            if(game.validationWinOrDraw(board, gamerX, 'x'))
                break;
			
			game.inputCoordinates(gamerO, board);
			board.showBoard();
            if(game.validationWinOrDraw(board, gamerO, 'o'))
                break;
	    }
	}
}
