public class Main {
  public static void main(String[] args) {
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
