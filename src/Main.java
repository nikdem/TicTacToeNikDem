public class Main {
    private static Gamer gamerX;
    private static Gamer gamerO;

	public static void main(String[] args) {
        Menu menu = new Menu();

        if(menu.getSelectionHumansOrComp() == 1) {
            gamerX = new Gamer('X');
            gamerO = new Gamer('O');
        } else {
            gamerX = new Gamer('X');
            gamerO = new GamerComp();
        }
		
		Board board = new Board(menu);
		Game game = new Game(board, gamerX, gamerO);
        board.showBoard();

		for(int countStep = 1; ; countStep++) {
            game.stepPlayers(countStep);
        	if(game.getQuit()) break;
		}
  	}
}
