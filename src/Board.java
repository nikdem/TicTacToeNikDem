import java.util.Scanner;

public class Board {
    private int sizeBoard = 3;
    private char[][] cell;

    Board() {
        cell = new char[sizeBoard][sizeBoard];
        for(int i = 0; i < cell.length; i++)
            for(int j = 0; j < cell.length; j++)
                cell[i][j] = '#';
    }

    public void setCell(int x, int y, char orOX) {
		cell[x][y] = orOX;
	}
	
	public char getCell(int x, int y) {
		return cell[x][y];
	}
	
	public int getCellLength() {
		return cell.length; 
	}	
	
	public void showBoard() {
		System.out.println();
		for(int i = 0; i < cell.length; i++) {
			for(int j = 0; j < cell.length; j++)
				System.out.print(cell[i][j] + " ");
			System.out.println();
		}
		System.out.println();
	}
}
