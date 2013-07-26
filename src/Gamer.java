import java.util.Scanner;

public class Gamer {
    private String namePlayer;
    private char orOX;

	public String getNamePlayer(){
		return namePlayer;
	}
	public int getOrOX(){
		return orOX;
	}

    Gamer(char orOX) {
        this.orOX = orOX;
        System.out.print("Введите имя " + orOX + "-игрока, или нажмите Enter: ");
        Scanner sc = new Scanner(System.in);
        namePlayer = sc.nextLine();
        if(namePlayer.equals("")) {
            namePlayer = orOX +"-игрок";
            System.out.println(namePlayer);
        }
    }
}
