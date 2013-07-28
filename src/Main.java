import java.io.PrintStream;

public class Main {
  public static void main(String[] args) {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException ex) {
            System.err.println("Unsupported encoding set for console");
        }

		System.out.println("Привет! Это игра \"Крестики-Нолики\"");

        Gamer gamerX = new Gamer('X');
        Gamer gamerO = new Gamer('O');
		
		Board board = new Board();
		board.showBoard();
		
		Game game = new Game();
		for(int countStep = 1; ; countStep++) {
            game.stepPlayer(gamerX, board, 'x', countStep);
            if(game.getQuit()) break;

            game.stepPlayer(gamerO, board, 'o', countStep);
            if(game.getQuit()) break;
		}
	}
}
