import java.util.Random;
import java.util.Scanner;

public class Game {
    private final int MAX_LENGTH_LINE_WIN = 3;
	private int x;
	private int y;
    private boolean quit = false;
    private char orOX;
    private Gamer gamerO;
    private Gamer gamerX;
    private Board board;
    private Gamer gamer;

    public Game(Board board, Gamer gamerX, Gamer gamerO) {
        this.board = board;
        this.gamerO = gamerO;
        this.gamerX = gamerX;
    }

    public boolean getQuit() {
        return quit;
    }

    public void inputCoordinates(Board b) {
        System.out.println("Comp, ввел координаты клетки:");
        while(true) {
            x = (new Random()).nextInt(b.getCellLength());
            y = (new Random()).nextInt(b.getCellLength());

            if (validationCell(x, y, b)) {
                b.setCell(x, y, 'o');
                break;
            }
        }

        System.out.println("  Строка(1-" + b.getCellLength() + "): " + (x+1));
        System.out.println("  Столбец(1-" + b.getCellLength() + "): " + (y+1));
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

        //проверка на ничью
		for(int i = 0; i < b.getCellLength(); i++)
			for(int j = 0; j < b.getCellLength(); j++)
			    if(b.getCell(i, j) == '#')
				    count2++;
		if(count2 == 0) {
				System.out.println("Ничья!");
                return true;
		}

        for(int i = 0; i < b.getCellLength() - MAX_LENGTH_LINE_WIN || i == 0; i++)
            for(int j = 0; j < b.getCellLength() - MAX_LENGTH_LINE_WIN || j == 0; j++) {
                    char[][] cell2 = new char[MAX_LENGTH_LINE_WIN][MAX_LENGTH_LINE_WIN];
                    for(int x = 0; x < cell2.length; x++)
                        for(int y = 0; y < cell2.length; y++)
                            cell2[x][y] = b.getCell(i + x, j + y);

                    //проверка на горизонталь
                    for(int x = 0, count = 0; x < cell2.length; x++) {
                        for(int y = 0; y < cell2.length; y++)
                            if(cell2[x][y] == orOX)
                                count++;
                            else
                                count = 0;
                        if(count == MAX_LENGTH_LINE_WIN) {
                            System.out.println("Победил " + g.getNamePlayer() + "!");
                            return true;
                        }
                    }

                    //проверка на вертикаль
                    for(int y = 0, count = 0; y < cell2.length; y++) {
                        for(int x = 0; x < cell2.length; x++)
                            if(cell2[x][y] == orOX)
                                count++;
                            else
                                count = 0;
                        if(count == MAX_LENGTH_LINE_WIN) {
                            System.out.println("Победил " + g.getNamePlayer() + "!");
                            return true;
                        }
                    }

                    //проверка на диагональ вида "\"
                    for(int x = 0, count = 0; x < cell2.length; x++) {
                        if(cell2[x][x] == orOX)
                            count++;
                        else
                            count = 0;
                        if(count == MAX_LENGTH_LINE_WIN) {
                            System.out.println("Победил " + g.getNamePlayer() + "!");
                            return true;
                        }
                    }

//                  //проверка на диагональ вида "/"
                    for(int x = 0, count = 0; x < cell2.length; x++) {
                        System.out.println("!");
                            if(cell2[x][cell2.length - 1 - x] == orOX)
                                count++;
                            else
                                count = 0;
                            if(count == MAX_LENGTH_LINE_WIN) {
                                System.out.println("Победил " + g.getNamePlayer() + "!");
                                return true;
                        }
                    }


            }

        //проверка на ничью
        for(int i = 0; i < b.getCellLength(); i++)
            for(int j = 0; j < b.getCellLength(); j++)
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

        if(gamer.getNamePlayer().equals("Comp"))
            inputCoordinates(board);
        else
            inputCoordinates(gamer, board);

        board.showBoard();
        if(countStep >= MAX_LENGTH_LINE_WIN)
            if(validationWinOrDraw(board, gamer, orOX))
                quit = true;
    }
}