//import java.io.IOException;
import java.util.Scanner;

public class Game {
	private int x;
	private int y;
	
	public void inputCoordinates(Gamer g, Board b) {
		System.out.println(g.getNamePlayer() + ", введите координаты клетки:");
		Scanner sc = new Scanner(System.in);
		while(true) {
            System.out.print("  Строка(1-" + b.getCellLength() + "):  ");
			x = sc.nextInt() - 1;
            System.out.print("  Столбец(1-" + b.getCellLength() + "):  ");
			y = sc.nextInt() - 1;

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
		for(int i=0; i < b.getCellLength(); i++) {
			int count=0;
			for(int j=0; j <b.getCellLength(); j++)
				if(b.getCell(i, j) == orOX) 
					count++;
			if(count == 3) {
				System.out.println("Победил " + g.getNamePlayer() + "!");
				return true;
		        }
		}
		
		for(int j=0; j < b.getCellLength(); j++) {
			int count=0;
			for(int i=0; i <b.getCellLength(); i++)
				if(b.getCell(i, j) == orOX) 
					count++;
			if(count == 3) {
                System.out.println("Победил " + g.getNamePlayer() + "!");
                return true;
            }
		}
		
		for(int i=0, count=0; i < b.getCellLength(); i++) {
			if(b.getCell(i, i) == orOX) 
				 count++;
			if(count == 3) {
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
}
