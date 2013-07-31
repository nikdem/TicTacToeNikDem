public class Main {
	public static void main(String[] args) {
		System.out.println("Привет! Это игра \"Крестики-Нолики\"");

        Gamer gamerX = new Gamer('X');
        Gamer gamerO = new Gamer('O');
		
		Board board = new Board();
		Game game = new Game(board, gamerO, gamerX);
        board.showBoard();

		for(int countStep = 1; ; countStep++) {
            game.stepPlayers(countStep);
        	if(game.getQuit()) break;
		}
  	}
}
