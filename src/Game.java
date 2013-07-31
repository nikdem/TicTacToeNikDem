//import java.io.IOException;
import java.util.Scanner;

public class Game {
    private final int MAX_LENGTH_LINE_WIN = 3;
	private int x;
	private int y;
    private boolean quit = false;
    private char orOX;
    private String gameSelection;
    private Gamer gamerO;
    private Gamer gamerX;
    private Board board;
    private Gamer gamer;

    public Game(Board board, Gamer gamerO, Gamer gamerX) {
        this.board = board;
        this.gamerO = gamerO;
        this.gamerX = gamerX;

        System.out.println("Выберите один из пунктов:");
        System.out.print("   1. Игра \"Человек-Человек\".\n" +
                         "   2. Игра \"Человек-Компьютер\".\n" +
                         "Пункт: ");
        Scanner sc = new Scanner(System.in);
        while(true) {
            gameSelection = sc.nextLine();
            if(gameSelection.equals("1") || gameSelection.equals("2") )
                break;
            else
                System.out.print("Вводите только 1 или 2: ");
        }
    }

    public boolean getQuit() {
        return quit;
    }
	
	public void inputCoordinates(Gamer g, Board b) {
		System.out.println(g.getNamePlayer() + ", введите координаты клетки:");
		Scanner sc = new Scanner(System.in);
		while(true) {
            boolean wrongInput = false;
            try {
            System.out.print("  Строка(1-" + b.getCellLength() + "):  ");
            x = sc.nextInt() - 1;
            System.out.print("  Столбец(1-" + b.getCellLength() + "):  ");
			y = sc.nextInt() - 1;
            } catch (Exception e) {
                System.out.println("Вводите только цифры!");
                wrongInput = true;
                // насколько я понимаю, это метод пропускает
                // введенные данные по шаблону, в данном случае - ".*"(пропускает всё)
                sc.skip(".*");
            }

            if(wrongInput) continue;

			if (validationCell(x, y, b)) {
				if(g.getOrOX() == 'O') {
					b.setCell(x, y, 'o');
				} else {
					b.setCell(x, y, 'x');
				}
				break;
				} else {
					System.out.println(g.getNamePlayer() + ", введите другие координаты клетки:");
				}
		}
	}
	
	public boolean validationWinOrDraw(Board b, Gamer g, char orOX) {
        int count2 = 0;
		for(int i = 0; i < b.getCellLength(); i++) {
			int count = 0;
			for(int j = 0; j < b.getCellLength(); j++)
				if(b.getCell(i, j) == orOX) 
					count++;
			if(count == MAX_LENGTH_LINE_WIN) {
				System.out.println("Победил " + g.getNamePlayer() + "!");
				return true;
		        }
		}
		
		for(int j = 0; j < b.getCellLength(); j++) {
			int count = 0;
			for(int i = 0; i <b.getCellLength(); i++)
				if(b.getCell(i, j) == orOX) 
					count++;
			if(count == MAX_LENGTH_LINE_WIN) {
                System.out.println("Победил " + g.getNamePlayer() + "!");
                return true;
            }
		}
		
		for(int i=0, count=0; i < b.getCellLength(); i++) {
			if(b.getCell(i, i) == orOX) 
				 count++;
			if(count == MAX_LENGTH_LINE_WIN) {
                System.out.println("Победил " + g.getNamePlayer() + "!");
                return true;
            }
		}
		
		for(int i=0; i < b.getCellLength(); i++)
			for(int j=0; j < b.getCellLength(); j++)
			if(b.getCell(i, j) == '#') 
				 count2++;
		    if(count2 == 0) {
				System.out.println("Ничья!");
                return true;
		}

        return false;
	}
		
	private boolean validationCell(int x, int y, Board b) {
		if(x < b.getCellLength() && x >= 0 && y < b.getCellLength() && y >= 0) {
			if (b.getCell(x, y) == 'o' || b.getCell(x, y) == 'x')
				return false;
			else
				return true;	
		} else
			return false;
	}

    public void stepPlayers(int countStep) {
        if(countStep % 2 == 0) {
            gamer = gamerO;
            orOX = 'o';
        } else {
            gamer = gamerX;
            orOX = 'x';
        }
        inputCoordinates(gamer, board);
        board.showBoard();
        if(countStep >= board.getCellLength())
            if(validationWinOrDraw(board, gamer, orOX))
                quit = true;
    }
}
