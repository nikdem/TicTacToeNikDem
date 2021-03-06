import java.util.Scanner;

public class Menu {
    private int selectionHumansOrComp;
    private int selectDimension;
    private int dimensionBoard;

    public int getDimensionBoard() {
        return dimensionBoard;
    }

    public int getSelectionHumansOrComp() {
        return selectionHumansOrComp;
    }

    Menu() {
        System.out.println("Привет! Это игра \"Крестики-Нолики\"");
        System.out.print("Выберите один из пунктов:\n" +
                         "    1. Игра \"Человек-Человек\".\n" +
                         "    2. Игра \"Человек-Компьютер\".\n" +
                "Пункт: ");
        Scanner sc = new Scanner(System.in);
        while(true) {
            try {
                selectionHumansOrComp = sc.nextInt();
            } catch(Exception e) {
                sc.skip(".*");
            }
            if(selectionHumansOrComp != 1 && selectionHumansOrComp != 2)
                System.out.print("Введите только 1 или 2: ");
            else
                break;
        }

        System.out.print("Выберите размерность поля:\n" +
                "    1. 3х3.\n" +
                "    2. 4х4.\n" +
                "    3. 5х5.\n" +
                "    4. Другой.\n" +
                "Пункт: ");
        while(true) {
            try {
                selectDimension = sc.nextInt();
            } catch(Exception e) {
                sc.skip(".*");
            }
            if(selectDimension >= 1 && selectDimension <= 4)
                break;
            else
                System.out.print("Введите только от 1 до 4: ");
        }


        switch(selectDimension) {
            case 1:
                dimensionBoard = 3; break;
            case 2:
                dimensionBoard = 4; break;
            case 3:
                dimensionBoard = 5; break;
            case 4: {
                selectDimension = 0;
                System.out.print("Введите размерность поля(3-20): ");
                while(true) {
                    try {
                        selectDimension = sc.nextInt();
                    } catch(Exception e) {
                        sc.skip(".*");
                    }
                    if(selectDimension >= 3 && selectDimension <= 20)
                        break;
                    else
                        System.out.print("Введите только число(3-20): ");
                }
                dimensionBoard = selectDimension; break;
            }
        }
    }
}
