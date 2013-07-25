//import java.io.IOException;
import java.util.Scanner;

public class Game {
  private int x;
	private int y;
	
	public void inputCoordinates(Gamer g, Board b) {
		System.out.println(g.getName() + ", enter the coordinates of the cell:");
		Scanner sc = new Scanner(System.in);
		while(true) {
    //Вот небольшая проблема с исключениями, пока не очень хватает знаний:)
//			try {		
				x = sc.nextInt ();
				y = sc.nextInt ();
//				if(x >= b.getCellLength() || x < 0 || y >= b.getCellLength() || y < 0)
//				   new IOException();
//			} catch (IOException e) {
//				System.out.println("Enter only the numbers and anywhere from 0 to " + (b.getCellLength() - 1) + ":");
//				continue Again;
//			}
				
				if (validationCell(x, y, b)) {
					if(g.getOrOX() == 0) {
						b.setCell(x, y, 'o');
					} else {
						b.setCell(x, y, 'x');
					}
					break;
				} else {
					System.out.println(g.getName() + ", enter the coordinates of the other cells:");
					continue;
				}		
		}
	}
	
	public String validationWin(Board b, char orOX) {
		int count2 = 0;
		for(int i=0; i < b.getCellLength(); i++) {
			int count=0;
			for(int j=0; j <b.getCellLength(); j++)
				if(b.getCell(i, j) == orOX) 
					count++;
			if(count == 3) return "three";
		}
		
		for(int j=0; j < b.getCellLength(); j++) {
			int count=0;
			for(int i=0; i <b.getCellLength(); i++)
				if(b.getCell(i, j) == orOX) 
					count++;
			if(count == 3) return "three";
		}
		
		for(int i=0, count=0; i < b.getCellLength(); i++) {
			if(b.getCell(i, i) == orOX) 
				 count++;
			if(count == 3) return "three";
		}
		
		for(int i=0; i < b.getCellLength(); i++)
			for(int j=0; j < b.getCellLength(); j++)
			if(b.getCell(i, j) == '#') 
				 count2++;
		if(count2 == 0) return "draw";
					
		
		return "notThree";
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
