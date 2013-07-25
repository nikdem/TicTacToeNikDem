public class Board {
  
  // Я конечно понимаю, что так проще ))) но стоит подумать о возможности расширения доски в будущем. При таком однотипном массиве выглядит индусятски, как на мой взгляд.
  private char[][] cell = {			
			{'#', '#', '#'},
			{'#', '#', '#'},
			{'#', '#', '#'}
	};
	
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
		for(int i=0; i < cell.length; i++) {
			for(int j=0; j <cell.length; j++)
				System.out.print(cell[i][j] + " ");
		        } // Скобка потерялась
			System.out.println();
		}
		System.out.println();
	}
}
